package com.psna.digilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.psna.digilearn.model.Role;
import com.psna.digilearn.model.User;
import com.psna.digilearn.service.RoleService;
import com.psna.digilearn.service.SecurityService;
import com.psna.digilearn.service.UserService;
import com.psna.digilearn.validator.UserValidator;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println(userForm.getUsername());
        
        Role role = roleService.getRole(userForm.getRole_code());
        
        userForm.setRole(role);

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
    	
        if (error != null)
        	model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "index";
    }

    @GetMapping({"/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @GetMapping({"/"})
    public String home(Model model) {
        return "index";
    }
    
    @GetMapping("/landing")
    public String landing(Model model) {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	    String currentUserName = authentication.getName();
    	    User user = userService.findByUsername(currentUserName);
        	model.addAttribute(user);
        	System.out.println(user.getUsername());
        	if(user.getRole().getName().equals("STUD"))
        		return "student";
        	else
        		return "faculty";
    	}
    	System.out.println("No user foundddd");
    	return "welcome";
    	
    }
}