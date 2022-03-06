package com.ddoong2.spring_sketeton.springbootstarter.configuration;


import com.ddoong2.spring_sketeton.springbootstarter.datasource.ReplicationRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

@Slf4j
@Configuration
@ConditionalOnMissingBean(DataSource.class)
@ConditionalOnProperty(prefix = "skeleton.datasource.write", name = "driver-class-name")
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({
        SkeletonDataSourceReadProperties.class,
        SkeletonDataSourceWriteProperties.class
})
public class SkeletonDataSourceAutoConfiguration {

    @Bean
    public DataSource writeDataSource(final SkeletonDataSourceWriteProperties writeProperties) {

        log.info("SkeletonDataSourceAutoConfiguration: 'writeDataSource'");
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(writeProperties.getDriverClassName())
                .url(writeProperties.getJdbcUrl())
                .username(writeProperties.getUsername())
                .password(writeProperties.getPassword())
                .build();
    }

    @Bean
    public DataSource readDataSource(final SkeletonDataSourceReadProperties readProperties) {

        log.info("SkeletonDataSourceAutoConfiguration: 'readDataSource'");
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .type(HikariDataSource.class)
                .driverClassName(readProperties.getDriverClassName())
                .url(readProperties.getJdbcUrl())
                .username(readProperties.getUsername())
                .password(readProperties.getPassword())
                .build();
    }

    @Bean
    public DataSource routingDataSource(final SkeletonDataSourceWriteProperties writeProperties,
                                        final SkeletonDataSourceReadProperties readProperties) {

        log.info("SkeletonDataSourceAutoConfiguration: 'routingDataSource'");
        return ReplicationRoutingDataSource.of(writeDataSource(writeProperties) ,
                readDataSource(readProperties));
    }

    @Bean
    @Primary
    public DataSource dataSource(final SkeletonDataSourceWriteProperties writeProperties,
                                 final SkeletonDataSourceReadProperties readProperties) {

        log.info("SkeletonDataSourceAutoConfiguration:'datasource'");
        return new LazyConnectionDataSourceProxy(routingDataSource(writeProperties, readProperties));
    }
}
