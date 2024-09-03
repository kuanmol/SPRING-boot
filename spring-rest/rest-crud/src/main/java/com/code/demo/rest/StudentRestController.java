package com.code.demo.rest;

import com.code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> thestudent;

    @PostConstruct
    public void loadData() {
        thestudent = new ArrayList<>();
        thestudent.add(new Student("pokemon", "sharma"));
        thestudent.add(new Student("sonic", "singh"));
        thestudent.add(new Student("mario", "chaturvedi"));

    }

    @GetMapping("student")
    public List<Student> getStudent() {
        return thestudent;
    }

    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        if ((studentID >= thestudent.size()) || (studentID < 0)) {
            throw new StudentNotFoundException("Student id not found in database : " + studentID);
        }
        return thestudent.get(studentID);
    }


}










