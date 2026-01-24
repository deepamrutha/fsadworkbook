package com.college.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
 

    @Autowired
    private Certification certification;

    public Student() {
        this.id = 1;
        this.name = "Thor";
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    

    public Certification getCertification() {
        return certification;
    }
}
