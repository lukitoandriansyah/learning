import SpringBoot.springBootLombokDemo.src.main.java.com.lukito.springbootlombokdemo.Student;
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
        return new Student();
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        students.add(new Student());
        students.add(new Student());
        return students;

    }
    //http://localhost:8080/student/lukito/itu
    @GetMapping({"studentli/{firstName}/{lastName}"})
    public Student studentPathVariable(@PathVariable("firstName") String firstName1, @PathVariable("lastName") String lastName2){
        return new Student();
    }

    //http://localhost:8080/student?firstName=lukito&lastName=itu
    @GetMapping("/student")
    public Student studentQueryParam(@RequestParam(name="firstName") String firstName, @RequestParam(name = "lastName") String lastName){
        return new Student();
    }
}
