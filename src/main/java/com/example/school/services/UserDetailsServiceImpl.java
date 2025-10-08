package com.example.school.services;

import com.example.school.entities.Account;
import com.example.school.repos.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger LOGGER= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final AccountRepo repository;

    public UserDetailsServiceImpl(AccountRepo repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = repository.findByUsername(username).get();
        if (account == null) throw new RuntimeException("User not found");
        return account;
    }
}