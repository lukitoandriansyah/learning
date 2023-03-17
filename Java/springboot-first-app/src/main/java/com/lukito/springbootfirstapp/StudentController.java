package com.lukito.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/get-student")
    public Student getStudent(){
        return new Student("Luki","Andri");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Andrian", "Syah1"));
        students.add(new Student("Andrian", "Syah2"));
        students.add(new Student("Andrian", "Syah3"));
        return students;

    }
}
