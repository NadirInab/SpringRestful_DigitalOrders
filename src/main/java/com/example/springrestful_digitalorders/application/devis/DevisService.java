package com.example.springrestful_digitalorders.application.devis;

import org.springframework.stereotype.Service;
import com.example.springrestful_digitalorders.domain.devis.Devis;

@Service
public interface DevisService {
    Devis generateDevis(Devis devis);

}
