package com.example.bookmovieticketsonline.controller;

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

    @GetMapping("showtime")
    public ResponseEntity<List<ShowtimeDTO>> getShowTime (@RequestParam LocalDate show_date) {
        List<ShowtimeDTO> showtimeDTOS = showtimeService.getShowTimesByShow_date(show_date);
        return new ResponseEntity<>(showtimeDTOS, HttpStatus.OK);
    }
}
