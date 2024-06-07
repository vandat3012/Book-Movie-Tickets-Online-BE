package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.dto.TheaterDTO;
import com.example.bookmovieticketsonline.model.entity.Theaters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITheaterRepository extends JpaRepository<Theaters,Long> {

    @Query(nativeQuery = true,value = "SELECT id,name from theaters")
    List<TheaterDTO> getTheater();
}
