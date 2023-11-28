package com.example.springrestful_digitalorders.Services;

import org.springframework.stereotype.Service;
import com.example.springrestful_digitalorders.entities.Devis;

import java.util.List;

@Service
public interface DevisService {
    Devis addDevis(Devis devis);

    public List<Devis> findAll();


}
