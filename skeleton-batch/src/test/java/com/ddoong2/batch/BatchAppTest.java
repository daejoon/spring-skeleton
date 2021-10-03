package com.ddoong2.batch;

import com.ddoong2.batch.base.DefaultTestProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatchAppTest implements DefaultTestProfile {

    @Test
    @DisplayName("배치 환경을 로드 합니다")
    void 배치_환경을_로드_합니다() throws Exception {
    }

}