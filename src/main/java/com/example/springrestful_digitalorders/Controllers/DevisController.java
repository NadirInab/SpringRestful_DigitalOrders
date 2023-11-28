package com.example.springrestful_digitalorders.Controllers;

import com.example.springrestful_digitalorders.entities.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public interface DevisController {

    public ResponseEntity<Devis> generateDevis(@RequestBody Devis devis);

    public List<Devis> findAll();

    public Map<String, String> showDevis(@RequestBody  Devis devis);

}
