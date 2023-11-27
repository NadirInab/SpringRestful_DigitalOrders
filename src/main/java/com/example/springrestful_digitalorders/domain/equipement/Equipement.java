package com.example.springrestful_digitalorders.domain.equipement;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;


    @NotNull(message = "dailyRentalCost cannot be null")
    @Column(name = "daily_rental_cost")
    private Double dailyRentalCost;

    private UUID uuid;

    private EquipementStatus status;

}
