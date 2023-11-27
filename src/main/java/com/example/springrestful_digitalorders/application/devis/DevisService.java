package com.example.springrestful_digitalorders.application.devis;

import org.springframework.stereotype.Service;
import com.example.springrestful_digitalorders.domain.devis.Devis;

import java.util.List;

@Service
public interface DevisService {
    Devis addDevis(Devis devis);

    public List<Devis> findAll();


}
