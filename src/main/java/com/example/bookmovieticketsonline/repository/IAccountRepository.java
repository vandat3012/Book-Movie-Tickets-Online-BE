package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findAccountsByUsername(String name);
}
