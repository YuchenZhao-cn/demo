package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @PostMapping(value="/insert")
    public Student insertStudent(@RequestBody Student student){
        if(!repository.findById(student.getId()).isPresent()) {
            repository.save(student);
        }
        return repository.findById(student.getId()).orElse(null);
    }

    @PutMapping(value="/update")
    public Student updateStudent(@RequestBody Student student){
        repository.save(student);
        return repository.findById(student.getId()).orElse(null);
    }

    @DeleteMapping(value="/delete/{id}")
    public Student deleteStudent(@PathVariable("id") int id){
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @GetMapping(value="/get")
    public List<Student> getStudents(){
        return repository.findAll();
    }
}
