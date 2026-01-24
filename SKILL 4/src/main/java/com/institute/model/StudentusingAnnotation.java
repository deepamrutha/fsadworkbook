package com.institute.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentusingAnnotation {

    private int studentId;
    private String name;
    private String course;
    private int year;

    public StudentusingAnnotation(
            @Value("202") int studentId,
            @Value("Gnaneswar") String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Value("Spring Boot")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("2026")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Year       : " + year);
    }
}
