package com.example.bookmovieticketsonline.controller;

import com.example.bookmovieticketsonline.config.service.JwtService;
import com.example.bookmovieticketsonline.model.dto.IMovieComingSoonDTO;
import com.example.bookmovieticketsonline.model.dto.IMovieShowingDTO;
import com.example.bookmovieticketsonline.model.entity.Movies;
import com.example.bookmovieticketsonline.service.IAccountService;
import com.example.bookmovieticketsonline.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IAccountService iAccountService;
    @PostMapping("createMovie")
    public ResponseEntity<Movies> createMovie(@RequestHeader("Authorization") String tokenHeader
                                              ,@RequestBody Movies movies
    ) {
        String token = tokenHeader.substring(7);
        String username = jwtService.getUsernameFromJwtToken(token);
        iAccountService.findAccountByUsername(username);
        iMovieService.save(movies);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("movieShowing")
    public ResponseEntity<List<IMovieShowingDTO>> findAllMovieShowing () {
        List<IMovieShowingDTO> movies = iMovieService.findAllByStatusShowing();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @GetMapping("movieComingSoon")
    public ResponseEntity<List<IMovieComingSoonDTO>> findAllMovieComingSoon () {
        List<IMovieComingSoonDTO> movies = iMovieService.findAllByStatusComingSoon();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }
}
