package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Accounts,Long> {

    Accounts findAccountsByUsername(String name);

    @Query(nativeQuery = true,value = "SELECT * from accounts a where a.username = :username")
    List<Accounts> checkUsername(@Param("username") String username);
}
