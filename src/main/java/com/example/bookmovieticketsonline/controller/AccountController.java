package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.config.service.JwtService;
import com.example.bookmovieticketsonline.model.dto.RegisterUser;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import com.example.bookmovieticketsonline.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("register/user")
    public ResponseEntity<String> registerAccountUser (@RequestBody RegisterUser user) {
        iAccountService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("checkUsername")
    public ResponseEntity<List<Accounts>> checkUsername (@RequestParam String username) {
        List<Accounts> accounts = iAccountService.checkUsername(username);
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @PostMapping("logout")
    public ResponseEntity<?> logout (@RequestHeader("Authorization") String tokenHeader) {
        String token = tokenHeader.substring(7);
        jwtService.addToBlackList(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
