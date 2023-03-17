package com.lukito.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/get-student")
    public Student getStudent(){
        return new Student("Luki","Andri");
    }
}
