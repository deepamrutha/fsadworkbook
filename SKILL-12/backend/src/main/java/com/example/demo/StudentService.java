package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
private final StudentRepository repo;
public StudentService(StudentRepository repo){this.repo=repo;}

public List<Student> getAll(){return repo.findAll();}
public Student add(Student s){return repo.save(s);}
public Student update(Long id,Student s){
Student st=repo.findById(id).orElseThrow();
st.setName(s.getName());
st.setEmail(s.getEmail());
st.setCourse(s.getCourse());
return repo.save(st);
}
public void delete(Long id){repo.deleteById(id);}
}
