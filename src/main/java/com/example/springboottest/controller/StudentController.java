package com.example.springboottest.controller;

import com.example.springboottest.entity.Student;
import com.example.springboottest.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    // Adding a student
    @PostMapping("/addStudent")
    private Student addStudent(@Valid @RequestBody Student student) {
        logger.info("Inside Student Controller, addStudent Method, RequestBody: ", student);
        return studentService.addStudent(student);
    }

    // Get all the student in the database
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get the student by ID
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

    // Get the list of students with names
    @GetMapping("/getStudentByName/{name}")
    public List<Student> getStudentByName(@PathVariable("name") String name) {
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public Student deleteStudentById(@PathVariable("id") Integer id) {
        return studentService.deleteStudentById(id);
    }

}
