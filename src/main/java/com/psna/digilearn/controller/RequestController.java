package com.psna.digilearn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.psna.digilearn.model.Request;
import com.psna.digilearn.model.User;
import com.psna.digilearn.service.RequestService;
import com.psna.digilearn.service.UserService;

@Controller
public class RequestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
	@PostMapping("/post")
	public String sendRequest(HttpServletRequest request) {
		
		String details = request.getParameter("details");
		String facultyName = request.getParameter("course_staff");
		String course_id = request.getParameter("course_id");
		
		User staff = userService.findByUsername(facultyName);
		
		Request newReq = new Request();
		
		newReq.setRequestDetails(details);
		newReq.setUser(staff);
		
		requestService.save(newReq);
		
		return "redirect:/course/" + course_id;
		
	}

}
