package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Demande;


import com.example.springrestful_digitalorders.entities.DevisStatus;
import org.springframework.stereotype.Service;
import com.example.springrestful_digitalorders.entities.Devis;

import java.util.List;
import java.util.Map;

@Service
public interface DevisService {
    Devis addDevis(Demande demande);

    public List<Devis> findAll();


    public Map<String, String> showDevis(Long id);

    public Devis updateStatus(Long id , DevisStatus devisStatus);

    public Devis updateDevis(Long id, Double discount);
}
