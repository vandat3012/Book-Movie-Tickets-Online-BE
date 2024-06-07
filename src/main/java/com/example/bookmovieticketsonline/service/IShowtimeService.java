package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IShowtimeService {

    List<InformationShowtimeDTO> getInfoByShow_date (LocalDate show_date,Long id_theater);

    List<ShowtimeDTO> getShowTimesByShow_date(LocalDate show_date,Long id_movie,Long id_theater);
}
