package org.abigballofmud.flink.platform.infra.utils;

import com.github.codingdebugallday.client.infra.exceptions.FlinkCommonException;
import lombok.extern.slf4j.Slf4j;
import org.abigballofmud.flink.platform.infra.autoconfigure.FlinkHiveCatalogProperties;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;
import org.apache.flink.table.functions.AggregateFunction;
import org.apache.flink.table.functions.ScalarFunction;
import org.apache.flink.table.functions.TableFunction;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2020/04/02 10:12
 * @since 1.0
 */
@Slf4j
public class FlinkUtil {

    private final StreamTableEnvironment tableEnv;

    public FlinkUtil(FlinkHiveCatalogProperties flinkHiveCatalogProperties) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .useBlinkPlanner()
                .inStreamingMode()
                .build();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        tableEnv = StreamTableEnvironment.create(env, settings);
        // 为了平台管理udf 集成hive
        String catalogName = flinkHiveCatalogProperties.getName();
        HiveCatalog hive = new HiveCatalog(catalogName,
                flinkHiveCatalogProperties.getDefaultDatabase(),
                flinkHiveCatalogProperties.getConfDir(),
                flinkHiveCatalogProperties.getVersion());
        tableEnv.registerCatalog(catalogName, hive);
        tableEnv.useCatalog(catalogName);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void registerFunction(String name, Object function) {
        if (function instanceof TableFunction) {
            tableEnv.registerFunction(name, (TableFunction) function);
        } else if (function instanceof AggregateFunction) {
            tableEnv.registerFunction(name, (AggregateFunction) function);
        } else if (function instanceof ScalarFunction) {
            tableEnv.registerFunction(name, (ScalarFunction) function);
        } else {
            throw new FlinkCommonException(String.format("Unknown UDF %s was found.", name));
        }
        log.info("register udf, name:{}, class:{}", name, function.getClass());
    }


}
