package com.example.springrestful_digitalorders.infrastructure.devis;

import com.example.springrestful_digitalorders.domain.devis.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DevisController {

    public ResponseEntity<Devis> generateDevis(@RequestBody Devis devis);


    public List<Devis> findAll();

}
