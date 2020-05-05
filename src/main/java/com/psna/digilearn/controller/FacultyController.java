package com.psna.digilearn.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psna.digilearn.model.Course;
import com.psna.digilearn.model.Request;
import com.psna.digilearn.model.User;
import com.psna.digilearn.service.CourseService;
import com.psna.digilearn.service.RequestService;
import com.psna.digilearn.service.UserService;

@Controller
public class FacultyController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private CourseService courseService;
	
	@Autowired
	private RequestService requestService;
	
	@GetMapping({"/faculty"})
	public String faculty(Model model,Principal principal) {
    	String username = principal.getName();
    	User user = userService.findByUsername(username);
    	List<Course> courses = courseService.findCoursesForStaff(user.getUsername());
    	System.out.println("Course owner: "+user.getUsername());
    	for(Course course : courses) {
    		System.out.println(course.getCourseName());
    	}
    	
    	List<Request> studentRequest = new ArrayList<Request>();
    	
    	try {
    		studentRequest = requestService.getRequests((long) user.getId().intValue());
    	}
    	catch(Exception e) {
    		System.out.println("No requests");
    	}
    	model.addAttribute("courses",courses);
    	model.addAttribute("requests",studentRequest);
    	model.addAttribute(user);
        return "faculty";
    }
	
	@GetMapping("/facultycourses")
    public @ResponseBody List<Course> getCourses(Model model,Principal principal){		
    	return courseService.findCoursesForStaff(principal.getName());
    }

}
