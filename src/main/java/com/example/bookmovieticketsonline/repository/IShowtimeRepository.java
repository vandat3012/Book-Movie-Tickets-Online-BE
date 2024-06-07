package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import com.example.bookmovieticketsonline.model.entity.ShowTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IShowtimeRepository extends JpaRepository<ShowTimes,Long> {

    @Query(nativeQuery = true,value = "SELECT m.id, m.image, m.name, m.genre\n" +
            "FROM theaters t\n" +
            "JOIN screens sc ON t.id = sc.theater_id\n" +
            "JOIN showtimes s ON sc.id = s.screen_id\n" +
            "JOIN movies m ON m.id = s.movie_id\n" +
            "WHERE s.show_date = :show_date AND t.id = :id_theater\n" +
            "GROUP BY m.id;")
    List<InformationShowtimeDTO> getInfoByShow_date (@Param("show_date") LocalDate show_date,
                                                     @Param("id_theater") Long id_theater);

    @Query(nativeQuery = true,value = "SELECT s.start_time, s.end_time\n" +
            "FROM theaters t\n" +
            "JOIN screens sc ON t.id = sc.theater_id\n" +
            "JOIN showtimes s ON sc.id = s.screen_id\n" +
            "JOIN movies m ON m.id = s.movie_id\n" +
            "WHERE s.show_date = :show_date AND m.id = :id_movie AND t.id = :id_theater")
    List<ShowtimeDTO> getShowTimesByShow_date(@Param("show_date") LocalDate show_date,
                                              @Param("id_movie") Long id_movie,
                                              @Param("id_theater") Long id_theater
    );

}
