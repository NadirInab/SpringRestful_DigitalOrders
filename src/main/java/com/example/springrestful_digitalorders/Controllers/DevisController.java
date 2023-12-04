package com.example.springrestful_digitalorders.Controllers;

import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public interface DevisController {

    public ResponseEntity<Devis> generateDevis(@RequestBody Devis devis);

    public List<Devis> findAll();

    public Map<String, String> showDevis(@PathVariable Long id);

    public Devis updateDevis(Long id,Double discount);

    public List<Devis> findAllWithNonNullDateCreation();

    public Devis updateStatus(Long id , DevisStatus devisStatus);

}
