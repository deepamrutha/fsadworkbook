
package com.university.controller;

import com.university.entity.Student;
import com.university.exception.InvalidInputException;
import com.university.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    private Map<Integer,Student> studentMap = new HashMap<>();

    public StudentController(){
        studentMap.put(1,new Student(1,"Deepa","CSE"));
        studentMap.put(2,new Student(2,"Rahul","ECE"));
        studentMap.put(3,new Student(3,"Anjali","IT"));
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){

        if(id<=0){
            throw new InvalidInputException("Student ID must be positive");
        }

        Student student = studentMap.get(id);

        if(student==null){
            throw new StudentNotFoundException("Student with ID "+id+" not found");
        }

        return student;
    }
}
