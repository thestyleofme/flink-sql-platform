package org.abigballofmud.flink.platform.infra.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * flink hive集成配置
 * </p>
 *
 * @author isacc 2020/5/9 16:13
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(FlinkHiveCatalogProperties.class)
public class FlinkHiveCatalogAutoConfigure {
}
