package com.ddoong2.spring_skeleton.api;

import com.ddoong2.spring_skeleton.api.base.DefaultTestProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiAppTest implements DefaultTestProfile {

    @Test
    @DisplayName("API 환경을 로드합니다")
    void API_환경을_로드합니다() throws Exception {
    }
}