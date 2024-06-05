package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.dto.IMovieComingSoonDTO;
import com.example.bookmovieticketsonline.model.dto.IMovieShowingDTO;
import com.example.bookmovieticketsonline.model.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movies,Long> {
    @Query(nativeQuery = true,value = "SELECT m.id,m.image,m.name,m.genre,m.time from movies m where m.status = 'Đang công chiếu'")
    List<IMovieShowingDTO> findAllByStatusShowing();

    @Query(nativeQuery = true,value = "SELECT m.image,m.name,m.genre,m.time from movies m where m.status = 'Sắp ra mắt'")
    List<IMovieComingSoonDTO> findAllByStatusComingSoon();
}
