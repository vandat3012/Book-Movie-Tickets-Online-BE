package com.example.bookmovieticketsonline.model.dto;

import java.time.LocalTime;

public interface ShowtimeDTO {
    String getImage();
    String getName();
    String getGenre();
    LocalTime getStart_time();
    LocalTime getEnd_time();
}
