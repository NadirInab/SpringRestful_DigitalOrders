package com.example.springrestful_digitalorders.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.springrestful_digitalorders.entities.DemandeStatus ;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;


    @Column(name = "end_date" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Date createdAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "demande_status")
    private DemandeStatus demandeStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Equipement equipement;
}
