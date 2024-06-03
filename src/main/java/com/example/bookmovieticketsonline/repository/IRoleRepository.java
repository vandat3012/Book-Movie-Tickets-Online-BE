package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Roles,Long> {
    Roles findByName (String name);
}
