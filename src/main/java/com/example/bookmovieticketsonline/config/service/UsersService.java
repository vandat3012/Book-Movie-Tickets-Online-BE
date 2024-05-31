package com.example.bookmovieticketsonline.config.service;

import com.example.bookmovieticketsonline.config.UsersPrinciple;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import com.example.bookmovieticketsonline.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;


    public Accounts findByUsername(String name) {
        return iAccountRepository.findAccountsByUsername(name);
    }

    public UserDetails loadUserByUsername(String username) {
        return UsersPrinciple.build(iAccountRepository.findAccountsByUsername(username));
    }


}
