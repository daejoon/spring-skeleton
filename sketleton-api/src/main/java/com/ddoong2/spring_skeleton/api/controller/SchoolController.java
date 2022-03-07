package com.ddoong2.spring_skeleton.api.controller;

import com.ddoong2.spring_skeleton.api.entity.Room;
import com.ddoong2.spring_skeleton.api.entity.Student;
import com.ddoong2.spring_skeleton.api.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SchoolController {

    private final SchoolService studentService;

    @GetMapping("/room")
    public List<Room> rooms() {
        final List<Room> rooms = studentService.findRoomAll();
        return rooms;
    }

    @GetMapping("/student")
    public List<Student> students() {
        final List<Student> students = studentService.findStudentAll();
        return students;
    }

}
