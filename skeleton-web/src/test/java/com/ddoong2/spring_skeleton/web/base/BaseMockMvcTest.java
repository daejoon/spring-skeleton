package com.ddoong2.spring_skeleton.web.base;

import com.ddoong2.spring_skeleton.web.config.TestMockMvcConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith({SpringExtension.class})
@Import({TestMockMvcConfig.class})
public abstract class BaseMockMvcTest implements DefaultTestProfile {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper mapper;
}
