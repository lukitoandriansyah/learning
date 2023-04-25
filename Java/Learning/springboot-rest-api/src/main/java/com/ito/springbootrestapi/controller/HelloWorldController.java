package com.ito.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    //Link "http://localhost:8080/hello"
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
