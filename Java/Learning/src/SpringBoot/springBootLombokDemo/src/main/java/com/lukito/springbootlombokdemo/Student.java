package SpringBoot.springBootLombokDemo.src.main.java.com.lukito.springbootlombokdemo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String address;

    public Student() {
    }
}
