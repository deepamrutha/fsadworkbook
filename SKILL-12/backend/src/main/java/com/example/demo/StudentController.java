package com.example.demo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

private final StudentService service;
public StudentController(StudentService service){this.service=service;}

@GetMapping
public ResponseEntity<List<Student>> getAll(){
return ResponseEntity.ok(service.getAll());
}

@PostMapping
public ResponseEntity<Student> add(@RequestBody Student s){
return new ResponseEntity<>(service.add(s),HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Student> update(@PathVariable Long id,@RequestBody Student s){
return ResponseEntity.ok(service.update(id,s));
}

@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id){
service.delete(id);
return ResponseEntity.ok("Deleted");
}
}
