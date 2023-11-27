package com.example.springrestful_digitalorders.domain.devis;


import com.example.springrestful_digitalorders.domain.contract.Contract;
import com.example.springrestful_digitalorders.domain.demande.Demande;
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
    private Double cost;

    private Date dateCreation;
    private Date dateExpiration;

   @ManyToOne
    private Demande demande;

    @OneToOne(mappedBy = "devis")
    @PrimaryKeyJoinColumn
    private Contract contract;

}
