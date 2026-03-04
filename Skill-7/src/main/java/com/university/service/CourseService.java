
package com.university.service;

import org.springframework.stereotype.Service;
import com.university.entity.Course;

import java.util.*;

@Service
public class CourseService {

    private Map<Integer,Course> courseMap = new HashMap<>();

    public Course addCourse(Course course){
        courseMap.put(course.getCourseId(),course);
        return course;
    }

    public List<Course> getAllCourses(){
        return new ArrayList<>(courseMap.values());
    }

    public Course getCourseById(int id){
        return courseMap.get(id);
    }

    public Course updateCourse(int id,Course course){
        courseMap.put(id,course);
        return course;
    }

    public boolean deleteCourse(int id){
        return courseMap.remove(id)!=null;
    }

    public List<Course> searchByTitle(String title){
        List<Course> result = new ArrayList<>();
        for(Course c:courseMap.values()){
            if(c.getTitle().toLowerCase().contains(title.toLowerCase())){
                result.add(c);
            }
        }
        return result;
    }
}
