package com.example.springrestful_digitalorders.domain.contract;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Contract {
@Id @GeneratedValue
private Long id;
    @OneToOne
    private Devis devis;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

}

