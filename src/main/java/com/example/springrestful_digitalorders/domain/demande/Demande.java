package com.example.springrestful_digitalorders.domain.demande;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name ;

    @NotNull(message = "dailyRentalCost cannot be null")
    @Column(name = "daily_rental_cost")
    private Double dailyRentalCost;

    private DemandeStatus demandeStatus;
}
