package SpringBoot.springBootWarDemo.src.main.java.com.lukito.springbootwardemo;

import jakarta.servlet.ServletException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWarDemoApplication.class);
    }

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {

    }
}
