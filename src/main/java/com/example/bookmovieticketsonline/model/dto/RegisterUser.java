package com.example.bookmovieticketsonline.model.dto;

import lombok.Data;

@Data
public class RegisterUser {
    private String username;
    private String password;
    private String confirmPassword;
}
