package com.ddoong2.spring_sketeton.springbootstarter.configuration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "skeleton.datasource.write")
public class SkeletonWriteDataSourceProperties {
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
}
