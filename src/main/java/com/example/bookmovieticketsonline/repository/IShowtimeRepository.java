package com.example.bookmovieticketsonline.repository;

import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import com.example.bookmovieticketsonline.model.entity.ShowTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IShowtimeRepository extends JpaRepository<ShowTimes,Long> {

    @Query(nativeQuery = true,value = "select m.image,m.name,m.genre,s.start_time,s.end_time\n" +
            "from movies m \n" +
            "join showtimes s on m.id = s.movie_id\n" +
            "where s.show_date = :show_date")
    List<ShowtimeDTO> getShowTimesByShow_date (@Param("show_date") LocalDate show_date);

}
