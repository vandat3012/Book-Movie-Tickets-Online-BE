package com.example.bookmovieticketsonline.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "showtimes")
public class ShowTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate show_date;
    private LocalTime start_time;
    private LocalTime end_time;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screens screens;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movies;
}
