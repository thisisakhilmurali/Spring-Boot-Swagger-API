package com.example.springboottest.service;

import com.example.springboottest.entity.Student;
import com.example.springboottest.exceptions.StudentNotFoundException;
import com.example.springboottest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceMain implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {

        Optional<Student> student = studentRepository.findById(id);

        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student with id: " + id + " does not exist");
        }

        return  student.get();
    }

    @Override
    public Student deleteStudentById(Integer id) {

        Optional<Student> student = studentRepository.findById(id);

        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student with id: " + id + " does not exist");
        }

        studentRepository.delete(student.get());

        return  null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }
}
