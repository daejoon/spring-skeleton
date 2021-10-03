package com.ddoong2.spring_skeleton.web.config;

import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@TestConfiguration
public class TestMockMvcConfig {

    @Bean
    MockMvcBuilderCustomizer utf8Config() {
        return builder ->
                builder.addFilters(new CharacterEncodingFilter("UTF-8", true));
    }
}
