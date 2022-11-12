package org.dandelion.cloud.sample.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * TODO data source config
 *
 * @author L
 * @version 1.0
 * @date 2022-10-06 13:36
 */
@Configuration
public class DataSourceConfig {

    @Value("${datasource.driver-class-name}")
    private String driverClass;

    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName(driverClass).url(url).username(username).password(password).build();
    }
}
