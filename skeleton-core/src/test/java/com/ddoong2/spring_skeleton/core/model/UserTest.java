package com.ddoong2.spring_skeleton.core.model;

import com.ddoong2.spring_skeleton.core.base.BaseDataJpaTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserTest extends BaseDataJpaTest {

    @Test
    @DisplayName("유저를 저장한다")
    void 유저를_저장한다() throws Exception {

        final String name = "홍길동";
        final User user = User.builder()
                .name(name)
                .age(15)
                .build();

        em.persist(user);
        final User findUser = em.find(User.class, user.getId());

        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getName()).isEqualTo(name);
    }

}