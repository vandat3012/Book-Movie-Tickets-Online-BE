package com.example.bookmovieticketsonline.service;

import com.example.bookmovieticketsonline.model.dto.IMovieComingSoonDTO;
import com.example.bookmovieticketsonline.model.dto.IMovieShowingDTO;
import com.example.bookmovieticketsonline.model.entity.Movies;

import java.util.List;

public interface IMovieService {

    void save (Movies movies);

    List<IMovieShowingDTO> findAllByStatusShowing();

    List<IMovieComingSoonDTO> findAllByStatusComingSoon();
}
