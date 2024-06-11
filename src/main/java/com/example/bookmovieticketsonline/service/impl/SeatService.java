package com.example.bookmovieticketsonline.service.impl;

import com.example.bookmovieticketsonline.model.dto.InformationBookTickets;
import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.SeatDTO;
import com.example.bookmovieticketsonline.model.entity.Seats;
import com.example.bookmovieticketsonline.repository.ISeatRepository;
import com.example.bookmovieticketsonline.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private ISeatRepository iSeatRepository;

    @Override
    public List<SeatDTO> findAllSeatsByScreenId(Long showtimeId) {
        return iSeatRepository.findAllSeatsByScreenId(showtimeId);
    }

    @Override
    public List<InformationBookTickets> findAllInfoByScreenId(Long showtimeId) {
        return iSeatRepository.findAllInfoByScreenId(showtimeId);
    }
}
