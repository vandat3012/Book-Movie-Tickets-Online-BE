package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IShowtimeService {

    List<ShowtimeDTO> getShowTimesByShow_date (LocalDate show_date);
}
