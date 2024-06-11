package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.model.dto.InformationBookTickets;
import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.SeatDTO;
import com.example.bookmovieticketsonline.model.entity.Seats;
import com.example.bookmovieticketsonline.service.IAccountService;
import com.example.bookmovieticketsonline.service.impl.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("getAllSeat")
    public ResponseEntity<List<SeatDTO>> getAllSeat(@RequestParam Long showtimeId) {
        List<SeatDTO> seatsList = seatService.findAllSeatsByScreenId(showtimeId);
        return new ResponseEntity<>(seatsList, HttpStatus.OK);
    }

    @GetMapping("getAllInfo")
    public ResponseEntity<List<InformationBookTickets>> getAllInfoTickets(@RequestParam Long showtimeId) {
        List<InformationBookTickets> informationBookTickets = seatService.findAllInfoByScreenId(showtimeId);
        return new ResponseEntity<>(informationBookTickets, HttpStatus.OK);
    }
}
