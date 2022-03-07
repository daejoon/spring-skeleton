package com.ddoong2.spring_skeleton.api.repository;

import com.ddoong2.spring_skeleton.api.entity.Student;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface StudentRepository extends Repository<Student, Long> {

    List<Student> findAll();

}
