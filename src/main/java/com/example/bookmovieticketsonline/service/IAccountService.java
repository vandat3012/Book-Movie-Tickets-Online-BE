package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.ChangePassword;
import com.example.bookmovieticketsonline.model.dto.RegisterUser;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountService {
    Accounts saveUser (RegisterUser user);

    List<Accounts> checkUsername(String username);

    Accounts changePassword (ChangePassword changePassword);
}
