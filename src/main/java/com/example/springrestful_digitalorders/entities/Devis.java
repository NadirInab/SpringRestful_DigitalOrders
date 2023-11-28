package com.example.springrestful_digitalorders.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DevisStatus devisStatus;

    private Date dateCreation;
    private Date dateExpiration;

    private Double discount;

   @ManyToOne
    private Demande demande;

}
