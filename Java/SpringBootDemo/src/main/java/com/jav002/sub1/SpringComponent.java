package com.jav002.sub1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringComponent {
    @Bean
    public String getMessage(){
        return "Yoo";
    }
}
