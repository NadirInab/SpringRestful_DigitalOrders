package com.example.springrestful_digitalorders.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {
@Id @GeneratedValue
private Long id;
    @OneToOne
    private Devis devis;

    private Boolean isArchived;
}

