package com.ddoong2.spring_skeleton.web.base;

import com.ddoong2.spring_skeleton.web.config.TestDataJpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

@Import(TestDataJpaConfig.class)
public abstract class BaseDataJpaTest implements DefaultTestProfile {

    @Autowired
    protected TestEntityManager em;
}
