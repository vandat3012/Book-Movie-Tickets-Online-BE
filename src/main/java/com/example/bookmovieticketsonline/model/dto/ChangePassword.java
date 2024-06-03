package com.example.bookmovieticketsonline.model.dto;

import lombok.Data;

@Data
public class ChangePassword {
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}
