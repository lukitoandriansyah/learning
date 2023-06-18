package com.ito.dockerspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @GetMapping("docker")
    public String dockerized(){
        return "This an example of docker";
    }
}
