package org.abigballofmud.flink.platform.infra.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2020/5/9 14:52
 * @since 1.0
 */
@Data
@ConfigurationProperties(FlinkHiveCatalogProperties.PREFIX)
public class FlinkHiveCatalogProperties {

    public static final String PREFIX = "flink.hive.catalog";

    /**
     * hive默认数据库
     */
    private String defaultDatabase = "hive";
    /**
     * flink HiveCatalog名称
     */
    private String name = "hdsp-hive";
    /**
     * hive版本
     */
    private String version = "3.1.0.3.1.0.0-78";
    /**
     * hive-site.xml文件所在路径
     */
    private String confDir = "/usr/hdp/3.1.0.0-78/hive/conf";

}
