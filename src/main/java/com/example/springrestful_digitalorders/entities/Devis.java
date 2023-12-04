package com.example.springrestful_digitalorders.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateExpiration;

    private Double discount;

    private Boolean isArchived;

   @ManyToOne
    private Demande demande;

}
