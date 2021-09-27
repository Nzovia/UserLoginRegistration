package com.nicholas.userloginregistration.controller;

import com.nicholas.userloginregistration.model.User;
import com.nicholas.userloginregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        //add the encryption Criteria to ensure that the password added is encrypted
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        return "register_success";
    }
    @GetMapping("/users")
    public  String listUsers(Model model){
        //implement a method to list all the users
        List<User> listAllUsers = userRepository.findAll();
        model.addAttribute("list", listAllUsers);

        return "users_list";
    }
    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }
}
