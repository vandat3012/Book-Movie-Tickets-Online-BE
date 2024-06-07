package com.example.bookmovieticketsonline.service.impl;

import com.example.bookmovieticketsonline.model.dto.TheaterDTO;
import com.example.bookmovieticketsonline.repository.ITheaterRepository;
import com.example.bookmovieticketsonline.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private ITheaterRepository iTheaterRepository;

    @Override
    public List<TheaterDTO> getTheater() {
        return iTheaterRepository.getTheater();
    }
}
