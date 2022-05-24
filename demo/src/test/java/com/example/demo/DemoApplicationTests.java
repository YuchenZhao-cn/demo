package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StudentRepository repository;

    @Test
    public void testCreateStudent(){

        Student student = new Student();
        student.setId(1);
        student.setFirstname("Yuchen");
        student.setLastname("Zhao");
        student.setScore(98);

        repository.save(student);

        Student savedStudent = repository.findById(1).get();
        System.out.println(savedStudent);
        assertNotNull(savedStudent);
    }
}
