package com.example.bookmovieticketsonline.service.impl;

import com.example.bookmovieticketsonline.model.dto.IMovieComingSoonDTO;
import com.example.bookmovieticketsonline.model.dto.IMovieShowingDTO;
import com.example.bookmovieticketsonline.model.entity.Movies;
import com.example.bookmovieticketsonline.repository.IMovieRepository;
import com.example.bookmovieticketsonline.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository iMovieRepository;
    @Override
    public void save(Movies movies) {
        iMovieRepository.save(movies);
    }

    @Override
    public List<IMovieShowingDTO> findAllByStatusShowing() {
        return iMovieRepository.findAllByStatusShowing();
    }

    @Override
    public List<IMovieComingSoonDTO> findAllByStatusComingSoon() {
        return iMovieRepository.findAllByStatusComingSoon();
    }
}
