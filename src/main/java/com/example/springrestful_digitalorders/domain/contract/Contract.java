package com.example.springrestful_digitalorders.domain.contract;


import com.example.springrestful_digitalorders.domain.devis.Devis;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
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

