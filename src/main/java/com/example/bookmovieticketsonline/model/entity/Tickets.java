package com.example.bookmovieticketsonline.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tickets")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts accounts;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private ShowTimes showTimes;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seats seats;
}
