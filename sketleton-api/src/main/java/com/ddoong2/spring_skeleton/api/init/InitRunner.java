package com.ddoong2.spring_skeleton.api.init;

import com.ddoong2.spring_skeleton.api.entity.Room;
import com.ddoong2.spring_skeleton.api.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class InitRunner implements ApplicationRunner {

    private final EntityManager entityManager;

    @Transactional
    @Override
    public void run(final ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 200; i++) {
            final Room room = Room.builder()
                    .id((long) i)
                    .name(String.format("%d 방", i))
                    .build();

            entityManager.persist(room);

            for (int j = 0; j < 10; j++) {
                final Student student = Student.builder()
                        .id(Long.valueOf(String.format("%d%d", i, j)))
                        .name(String.format("%d 학생, %d 방", j+1, room.getId()))
                        .room(room)
                        .build();

                entityManager.persist(student);
            }
        }
    }
}
