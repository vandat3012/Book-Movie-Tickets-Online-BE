package com.example.bookmovieticketsonline.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface InformationBookTickets {
    String getTheater_name();
    String getScreen_name();
    LocalTime getStart_time();
    LocalTime getEnd_time();
    LocalDate getShow_date();
    String getMovie_name();
}
