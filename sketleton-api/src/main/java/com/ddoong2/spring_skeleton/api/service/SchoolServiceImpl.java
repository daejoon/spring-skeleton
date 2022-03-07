package com.ddoong2.spring_skeleton.api.service;

import com.ddoong2.spring_skeleton.api.entity.Room;
import com.ddoong2.spring_skeleton.api.entity.Student;
import com.ddoong2.spring_skeleton.api.repository.RoomRepository;
import com.ddoong2.spring_skeleton.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SchoolServiceImpl implements SchoolService {

    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<Student> findStudentAll() {

        final List<Student> students = studentRepository.findAll();

        students.stream().forEach(student -> Hibernate.initialize(student.getRoom()));

        return students;
    }

    @Override
    public List<Room> findRoomAll() {
        final List<Room> rooms = roomRepository.findAll();
        rooms.stream().forEach(room -> Hibernate.initialize(room.getStudents()));
        return rooms;
    }
}
