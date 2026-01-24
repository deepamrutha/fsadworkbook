package com.institute.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.institute.model.Student;

public class XmlMain {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("student.xml");

        Student student = (Student) context.getBean("student");
        student.display();
    }
}
