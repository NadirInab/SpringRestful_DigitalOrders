package com.example.springrestful_digitalorders.domain.demande;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import com.example.springrestful_digitalorders.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    private DemandeStatus demandeStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Equipement equipement;
}
