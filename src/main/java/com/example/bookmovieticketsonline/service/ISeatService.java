package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.InformationBookTickets;
import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.SeatDTO;
import com.example.bookmovieticketsonline.model.entity.Seats;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatService {
    List<SeatDTO> findAllSeatsByScreenId(Long showtimeId);

    List<InformationBookTickets> findAllInfoByScreenId(Long showtimeId);
}
