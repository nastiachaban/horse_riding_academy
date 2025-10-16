package com.example.school.controllers;


import com.example.school.entities.Account;
import com.example.school.entities.Student;
import com.example.school.entities.enums.UserType;
import com.example.school.repos.StudentRepo;
import com.example.school.repos.TeacherRepo;
import com.example.school.repos.WorkerRepo;
import com.example.school.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
public class SchoolController {

    private final Logger LOGGER= LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private WorkerRepo workerRepo;

    @GetMapping("/home")
    public String getIndex(Model model){
//        Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(account.getUserType().equals(UserType.STUDENT)){
//            Student student=studentRepo.getStudentByAccountId(account.getId()).get();
//            if(student.getFirstname().isEmpty() || student.getLastname().isEmpty()){
//                model.addAttribute("hasName",false);
//            }
//            else{
//                model.addAttribute("name",student.getFirstname()+" "+student.getLastname());
//            }
//        }
        return "home";
    }
}
