package com.jav002.springdemo;

import com.jav002.sub1.SpringComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class, args);
        SpringComponent springComponent = applicationContext.getBean(SpringComponent.class);
        System.out.println(springComponent.getMessage());

    }

}
