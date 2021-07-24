package com.ddoong2.spring_skeleton.api;

import com.ddoong2.spring_skeleton.api.properties.SkeletonProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
@RequiredArgsConstructor
@ConfigurationPropertiesScan
@SpringBootApplication
public class ApiApp implements ApplicationRunner {

    private final SkeletonProperties skeletonProperties;

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("Module Name : '{}'", skeletonProperties.getName());
    }
}
