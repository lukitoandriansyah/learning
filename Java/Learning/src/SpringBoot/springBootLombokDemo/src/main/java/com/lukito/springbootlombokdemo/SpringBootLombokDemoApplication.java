package com.lukito.springbootlombokdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLombokDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootLombokDemoApplication.class, args);

        Student student = new Student();
        student.setId(1);
        student.setName("Ito");
        student.setAddress("Jakarta");

        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAddress());
    }

}
