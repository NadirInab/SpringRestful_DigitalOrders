package com.example.springrestful_digitalorders.domain.devis;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double cost;

   /* @ManyToOne
    private Demande demande;*/

}
