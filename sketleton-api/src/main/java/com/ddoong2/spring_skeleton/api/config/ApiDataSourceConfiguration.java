package com.ddoong2.spring_skeleton.api.config;


import com.ddoong2.spring_sketeton.springbootstarter.datasource.ReplicationRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

@Slf4j
//@Configuration(proxyBeanMethods = false)
public class ApiDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.read")
    @Qualifier("readDataSource")
    public DataSource readDataSource() {

        log.info("ApiDataSourceConfiguration 'read' ");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.write")
    @Qualifier("writeDataSource")
    public DataSource writeDataSource() {

        log.info("ApiDataSourceConfiguration 'write' ");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @Qualifier("routingDataSource")
    public DataSource routingDataSource(@Qualifier("writeDataSource") DataSource writeDataSource,
                                        @Qualifier("readDataSource") DataSource readDataSource ) {

        log.info("ApiDataSourceConfiguration 'routing' ");
        return ReplicationRoutingDataSource.of(writeDataSource, readDataSource);
    }

    @Bean
    @Qualifier("dataSource")
    @Primary
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {

        log.info("ApiDataSourceConfiguration 'datasource' ");
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}
