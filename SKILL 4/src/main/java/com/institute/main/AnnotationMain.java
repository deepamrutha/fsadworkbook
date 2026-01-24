package com.institute.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.institute.config.AppConfig;
import com.institute.model.StudentusingAnnotation;

public class AnnotationMain {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentusingAnnotation student =
                context.getBean(StudentusingAnnotation.class);

        student.display();
    }
}
