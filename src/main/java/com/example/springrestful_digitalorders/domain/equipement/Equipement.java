package com.example.springrestful_digitalorders.domain.equipement;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @Column(name = "daily_rental_cost")
    private Double dailyRentalCost ;

    private UUID uuid ;

    @Column(name = "picture")
    private String picture ;
}
