package com.college.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.college.config.AppConfig;
import com.college.model.Student;
import com.college.model.Certification;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean(Student.class);
        Certification cert = student.getCertification();

        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        

        System.out.println("Certification ID: " + cert.getId());
        System.out.println("Certification Name: " + cert.getName());
        System.out.println("Date of Completion: " + cert.getDateOfCompletion());
    }
}
