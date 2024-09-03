package com.springboot.thymleaf.controller;

import com.springboot.thymleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        model.addAttribute("countries",countries);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println("the student :" +student.getFirstName()+" "+student.getLastName());
        return "student-confirmation";
    }

}































