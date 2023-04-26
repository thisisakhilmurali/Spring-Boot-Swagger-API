package com.example.springboottest.service;

import com.example.springboottest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student deleteStudentById(Integer id);

    List<Student> getStudentByName(String name);
}
