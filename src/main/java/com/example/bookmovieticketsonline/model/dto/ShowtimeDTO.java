package com.example.bookmovieticketsonline.model.dto;

import java.time.LocalTime;

public interface ShowtimeDTO {
    Long getId();
    LocalTime getStart_time();
    LocalTime getEnd_time();
}
