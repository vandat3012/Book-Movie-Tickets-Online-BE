package com.example.bookmovieticketsonline.service.impl;

import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import com.example.bookmovieticketsonline.repository.IShowtimeRepository;
import com.example.bookmovieticketsonline.service.IShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowtimeService implements IShowtimeService {
    @Autowired
    private IShowtimeRepository iShowtimeRepository;

    @Override
    public List<InformationShowtimeDTO> getInfoByShow_date(LocalDate show_date,Long id_theater) {
        return iShowtimeRepository.getInfoByShow_date(show_date,id_theater);
    }

    @Override
    public List<ShowtimeDTO> getShowTimesByShow_date(LocalDate show_date, Long id_movie, Long id_theater) {
        return iShowtimeRepository.getShowTimesByShow_date(show_date,id_movie,id_theater);
    }
}
