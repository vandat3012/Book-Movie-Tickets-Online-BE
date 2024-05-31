package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.config.service.JwtResponse;
import com.example.bookmovieticketsonline.config.service.JwtService;
import com.example.bookmovieticketsonline.config.service.UsersService;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth/")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsersService usersService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Accounts accounts) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accounts.getUsername(), accounts.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Accounts currentAccount = usersService.findByUsername(accounts.getUsername());
        return ResponseEntity.ok(new JwtResponse(currentAccount.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
}
