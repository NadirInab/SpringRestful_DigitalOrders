package com.example.springrestful_digitalorders.Controllers;

import com.example.springrestful_digitalorders.Services.DevisService;
import com.example.springrestful_digitalorders.entities.Devis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/devis")
public class DevisControllerImpl implements DevisController {

    private final DevisService devisService;

    @PostMapping("/save")
    public ResponseEntity<Devis> generateDevis(@RequestBody Devis devis){
        Devis devis1 = devisService.addDevis(devis);

        if (devis1 != null) {
            return ResponseEntity.status(HttpStatus.OK).body(devis1);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/")
    public List<Devis> findAll() {
        return devisService.findAll();
    }

}
