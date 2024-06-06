package com.example.bookmovieticketsonline.service.impl;

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
    public List<ShowtimeDTO> getShowTimesByShow_date(LocalDate show_date) {
        return iShowtimeRepository.getShowTimesByShow_date(show_date);
    }
}
