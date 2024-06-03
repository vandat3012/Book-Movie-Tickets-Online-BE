package com.example.bookmovieticketsonline.service.impl;

import com.example.bookmovieticketsonline.model.dto.ChangePassword;
import com.example.bookmovieticketsonline.model.dto.RegisterUser;
import com.example.bookmovieticketsonline.model.entity.Accounts;
import com.example.bookmovieticketsonline.model.entity.Roles;
import com.example.bookmovieticketsonline.repository.IAccountRepository;
import com.example.bookmovieticketsonline.repository.IRoleRepository;
import com.example.bookmovieticketsonline.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Accounts saveUser(RegisterUser user) {
        if (!user.getPassword().equals(user.getConfirmPassword())){
            try {
                throw new Exception("The password is not match");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Accounts account = new Accounts();
        account.setUsername(user.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Roles rolesUser = iRoleRepository.findByName("ROLE_USER");
        Set<Roles> roles = new HashSet<>();
        roles.add(rolesUser);
        account.setRoles(roles);
        return iAccountRepository.save(account);
    }

    @Override
    public List<Accounts> checkUsername(String username) {
        return iAccountRepository.checkUsername(username);
    }

    @Override
    public Accounts changePassword(ChangePassword changePassword) {
//        if (!changePassword.getOldPassword().equals())
        return null;
    }
}
