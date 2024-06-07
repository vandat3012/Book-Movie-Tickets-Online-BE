package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.model.dto.TheaterDTO;
import com.example.bookmovieticketsonline.service.ITheaterService;
import com.example.bookmovieticketsonline.service.impl.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @GetMapping("theater")
    public ResponseEntity<List<TheaterDTO>> getTheater() {
        List<TheaterDTO> theaterDTOS = theaterService.getTheater();
        return new ResponseEntity<>(theaterDTOS, HttpStatus.OK);
    }
}
