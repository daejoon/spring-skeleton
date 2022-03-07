package com.ddoong2.spring_skeleton.api.repository;

import com.ddoong2.spring_skeleton.api.entity.Room;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface RoomRepository extends Repository<Room, Long> {
    List<Room> findAll();
}
