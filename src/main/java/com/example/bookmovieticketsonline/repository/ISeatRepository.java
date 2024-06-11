package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.dto.InformationBookTickets;
import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.SeatDTO;
import com.example.bookmovieticketsonline.model.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seats,Long> {
    @Query(nativeQuery = true,value = "SELECT s.*\n" +
            "FROM seats s\n" +
            "JOIN showtimes st ON s.screen_id = st.screen_id\n" +
            "WHERE st.id = :showtimeId")
    List<SeatDTO> findAllSeatsByScreenId(@Param("showtimeId") Long showtimeId);

    @Query(nativeQuery = true,value = "SELECT distinct\n" +
            "       t.name AS theater_name, \n" +
            "       s.name AS screen_name, \n" +
            "       st.start_time, \n" +
            "       st.end_time, \n" +
            "       st.show_date, \n" +
            "       m.name AS movie_name\n" +
            "FROM theaters t\n" +
            "JOIN screens s ON t.id = s.theater_id\n" +
            "JOIN seats se ON se.screen_id = s.id\n" +
            "JOIN showtimes st ON st.screen_id = s.id\n" +
            "JOIN movies m ON st.movie_id = m.id\n" +
            "WHERE st.id = :showtimeId")
    List<InformationBookTickets> findAllInfoByScreenId(@Param("showtimeId") Long showtimeId);
}
