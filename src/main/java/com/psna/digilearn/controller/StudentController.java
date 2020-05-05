package com.psna.digilearn.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.psna.digilearn.model.Course;
import com.psna.digilearn.model.User;
import com.psna.digilearn.service.CourseService;
import com.psna.digilearn.service.UserService;

@Controller
public class StudentController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CourseService courseService;
	
    @GetMapping({"/student"})
    public String student(Model model,Principal principal) {
    	String username = principal.getName();
    	User user = userService.findByUsername(username);
    	model.addAttribute(user);
        return "student";
    }
    
    @GetMapping("/student/{sem}")
    public String getCourses(@PathVariable("sem") int sem,Principal principal, Model model){
    	String username = principal.getName();
    	User user = userService.findByUsername(username);
    	List <Course> courses =courseService.findCourses(sem,user.getDepartment());
    	model.addAttribute("courses", courses);
    	return "semester";
    }

}
