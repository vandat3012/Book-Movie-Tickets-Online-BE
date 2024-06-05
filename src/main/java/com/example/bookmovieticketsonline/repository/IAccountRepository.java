package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findAccountByUsername(String username);

    Accounts findAccountsByUsername(String name);

    @Query(nativeQuery = true,value = "SELECT * from accounts a where a.username = :username")
    List<Accounts> checkUsername(@Param("username") String username);

    @Query(nativeQuery = true,value = "SELECT * from accounts a where a.email = :email")
    List<Accounts> checkEmail(@Param("email") String email);

    @Query(nativeQuery = true,value = "SELECT a.password from accounts a where a.id = :id")
    String findPasswordById(@Param("id") Long id);


}
