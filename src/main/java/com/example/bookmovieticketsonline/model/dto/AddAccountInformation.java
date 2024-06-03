package com.example.bookmovieticketsonline.model.dto;

import lombok.Data;

@Data
public class AddAccountInformation {
    private String email;
    private String avatar;
    private String full_name;
    private String phone_number;
    private String address;
    private String status;
}
