package com.ddoong2.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
public class BatchApp {
    public static void main(String[] args) {
        SpringApplication.run(BatchApp.class, args);
    }
}
