package com.ddoong2.spring_skeleton.web;

import com.ddoong2.spring_skeleton.web.properties.SkeletonProperties;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
@ConfigurationPropertiesScan
@RequiredArgsConstructor
@SpringBootApplication
public class WebApp implements ApplicationRunner {

    private final SkeletonProperties skeletonProperties;

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("Module Name : '{}'", skeletonProperties.getName());
    }
}
