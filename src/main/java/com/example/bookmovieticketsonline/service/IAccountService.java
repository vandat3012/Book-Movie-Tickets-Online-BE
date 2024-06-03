package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.AddAccountInformation;
import com.example.bookmovieticketsonline.model.dto.ChangePassword;
import com.example.bookmovieticketsonline.model.dto.RegisterUser;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Accounts> findAccountByUsername(String username);
    Accounts saveUser (RegisterUser user);

    List<Accounts> checkUsername(String username);

    void changePassword (String username,ChangePassword changePassword) throws Exception;

    Accounts addAccountInformation (String username,AddAccountInformation information);
}
