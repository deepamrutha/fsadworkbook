
package com.university.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.university.entity.Course;
import com.university.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        Course saved=service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id){
        Course course=service.getCourseById(id);
        if(course==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,@RequestBody Course course){
        if(service.getCourseById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok(service.updateCourse(id,course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        if(service.deleteCourse(id)){
            return ResponseEntity.ok("Course deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourses(@PathVariable String title){
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}
