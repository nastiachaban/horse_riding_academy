package com.example.school.controllers;


import com.example.school.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
public class SchoolController {

    private final Logger LOGGER= LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/home")
    public String getIndex(){
        return "home";
    }
}
