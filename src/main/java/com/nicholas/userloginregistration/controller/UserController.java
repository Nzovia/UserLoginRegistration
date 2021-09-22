package com.nicholas.userloginregistration.controller;

import com.nicholas.userloginregistration.model.User;
import com.nicholas.userloginregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public  String viewHomePage(){
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model){//to send a new user object
        model.addAttribute("user", new User());
        return "signup_form";
    }
    @PostMapping("/registration") // registration is the action in the form
    public String processRegistration(User user){
        userRepository.save(user);
        return "register_success";
    }
    @GetMapping("/users")
    public  String listUsers(){
        return "listofusers";
    }
    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }
}
