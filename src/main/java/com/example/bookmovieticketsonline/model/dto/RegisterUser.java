package com.example.bookmovieticketsonline.model.dto;

import lombok.Data;

@Data
public class RegisterUser {
    private String username;
    private String email;
    private String phone_number;
    private String status;
    private String password;
    private String confirmPassword;
}
