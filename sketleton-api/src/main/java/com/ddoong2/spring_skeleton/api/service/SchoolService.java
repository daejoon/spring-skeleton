package com.ddoong2.spring_skeleton.api.service;

import com.ddoong2.spring_skeleton.api.entity.Room;
import com.ddoong2.spring_skeleton.api.entity.Student;

import java.util.List;

public interface SchoolService {

    List<Student> findStudentAll();
    List<Room> findRoomAll();
}
