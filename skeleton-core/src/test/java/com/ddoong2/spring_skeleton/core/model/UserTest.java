package com.ddoong2.spring_skeleton.core.model;

import com.ddoong2.spring_skeleton.core.config.TestJpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestJpaConfig.class)
class UserTest {

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("유저를 저장한다")
    void 유저를_저장한다() throws Exception {

        final User user = User.builder()
                .name("홍길동")
                .age(15)
                .build();

        em.persist(user);
        final User findUser = em.find(User.class, 1L);
        assertThat(findUser.getName()).isEqualTo("홍길동");
    }

}