package com.ito.springbootrestfulwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Springboot Rest API Doc",
                description = "Desc Springboot Rest API",
                version = "v1.0",
                contact = @Contact(
                        name = "Lukito",
                        email = "lukitoandriansyah45@gmail.com",
                        url = "https://www.ito.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.ito.com/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Springboot User Management Doc",
                url = "https://www.ito.com/user_management.html"
        )
)
public class SpringbootRestfulWebservicesApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }

}
