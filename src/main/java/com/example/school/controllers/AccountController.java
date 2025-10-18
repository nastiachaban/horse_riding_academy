package com.example.school.controllers;

import com.example.school.entities.LogIn;
import com.example.school.entities.SignUp;
import com.example.school.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class AccountController {

    private final Logger LOGGER= LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountService service;

    @GetMapping("/logIn")
    public String logIn(Model model){
        model.addAttribute("account",new LogIn());
        LOGGER.info("redirect to login page");
        return "login";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam String username,@RequestParam String password,
                         @RequestParam String confirmPassword,@RequestParam String email) {
        LOGGER.info("post signup");
        service.signup(new SignUp(username, password, confirmPassword, email));

        return "redirect:/users/logIn";
    }

    @GetMapping("/signUp")
    public String signUp(Model model){
        LOGGER.info("get signup");
        model.addAttribute("username","");
        model.addAttribute("password","");
        model.addAttribute("confirmPassword","");
        model.addAttribute("email","");

        return "signup";
    }

    @PostMapping("/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "redirect:/users/logIn";
    }
}
