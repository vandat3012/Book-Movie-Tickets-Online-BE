package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.model.dto.InformationShowtimeDTO;
import com.example.bookmovieticketsonline.model.dto.ShowtimeDTO;
import com.example.bookmovieticketsonline.service.IShowtimeService;
import com.example.bookmovieticketsonline.service.impl.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping("infoShowtime")
    public ResponseEntity<List<InformationShowtimeDTO>> getInfoShowtime(@RequestParam LocalDate show_date, Long id_theater) {
        List<InformationShowtimeDTO> infoByShowDate = showtimeService.getInfoByShow_date(show_date, id_theater);
        return new ResponseEntity<>(infoByShowDate, HttpStatus.OK);
    }

    @GetMapping("showtime")
    public ResponseEntity<List<ShowtimeDTO>> getShowtime(@RequestParam LocalDate show_date,
                                                         @RequestParam Long id_movie,
                                                         @RequestParam Long id_theater) {
        List<ShowtimeDTO> showtimeDTOS = showtimeService.getShowTimesByShow_date(show_date, id_movie, id_theater);
        return new ResponseEntity<>(showtimeDTOS, HttpStatus.OK);
    }
}
