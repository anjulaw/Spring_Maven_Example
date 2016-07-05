package com.github.elizabetht.controller;

import com.github.elizabetht.model.Student;
import com.github.elizabetht.model.StudentLogin;
import com.github.elizabetht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * Created by anjulaw on 7/5/2016.
 */

@Controller
@SessionAttributes("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    private String url;

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String signup(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "signup";
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signup(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "signup";
        } else if(studentService.findByUserName(student.getUserName())) {
            model.addAttribute("message", "User Name exists. Try another user name");
            return "signup";
        } else {
            studentService.save(student);
            model.addAttribute("message", "Saved student details");
            return "redirect:login.html";
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        StudentLogin studentLogin = new StudentLogin();
        model.addAttribute("studentLogin", studentLogin);
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@Valid @ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        } else {
            boolean found = studentService.findByLogin(studentLogin.getUserName(), studentLogin.getPassword());
            if (found) {
                return "success";
            } else {
                return "failure";
            }
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
