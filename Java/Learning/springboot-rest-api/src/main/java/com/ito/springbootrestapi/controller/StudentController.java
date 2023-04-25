package com.ito.springbootrestapi.controller;

import com.ito.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    //Link "http://localhost:8080/student"
    @GetMapping("/ex")
    public ResponseEntity<Student> student(){
        Student student = new Student(1, "Lukito", "Andriansyah");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("custem-header", "Ito-Jos")
                .body(student);

    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> listStudent(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"Lukito","Andriansyah"));
        list.add(new Student(2, "Rachmat", "Safii"));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable int id){
        Student student = new Student(id, "Balsem", "Putra");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVar(@RequestParam int id){
        Student student = new Student(id, "Ito", "sos");
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}/delete")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
        return ResponseEntity.ok("Student Success Deleted");
    }
}
