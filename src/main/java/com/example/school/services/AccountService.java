package com.example.school.services;

import com.example.school.entities.Account;
import com.example.school.entities.Picture;
import com.example.school.entities.SignUp;
import com.example.school.entities.Student;
import com.example.school.entities.enums.UserType;
import com.example.school.repos.AccountRepo;
import com.example.school.repos.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private StudentRepo studentRepo;

    private final Logger LOGGER= LoggerFactory.getLogger(AccountService.class);

    @Transactional
    public void signup(SignUp request) {
        String username = request.getUsername();
        Optional<Account> existingUser = accountRepo.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new RuntimeException(String.format("Account with the same username '%s' already exists.", username));
        }

        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new RuntimeException("Passwords do not match");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        // Account account= new Account((new Random()).nextLong(),new Picture(), request.getUsername(),request.getEmail(),hashedPassword,UserType.STUDENT);
        Account account = Account.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(hashedPassword)
                .userType(UserType.STUDENT)
                .build();

        accountRepo.save(account);

        Student student= Student.builder().account(account).build();
        studentRepo.save(student);
    }

}
