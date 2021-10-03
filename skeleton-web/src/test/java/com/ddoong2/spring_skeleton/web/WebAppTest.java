package com.ddoong2.spring_skeleton.web;

import com.ddoong2.spring_skeleton.web.base.DefaultTestProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebAppTest implements DefaultTestProfile {

    @Test
    @DisplayName("웹 환경을 로드 합니다")
    void 웹_환경을_로드_합니다() throws Exception {
    }

}