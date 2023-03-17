package com.lukito.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping({"studentli/{firstName}/{lastName}"})
    public Student studentPathVariable(@PathVariable("firstName") String firstName1, @PathVariable("lastName") String lastName2){
        return new Student(firstName1, lastName2);
    }

    @GetMapping("/student")
    public Student studentQueryParam(@RequestParam(name="firstName") String firstName, @RequestParam(name = "lastName") String lastName){
        return new Student(firstName,lastName);
    }
}
