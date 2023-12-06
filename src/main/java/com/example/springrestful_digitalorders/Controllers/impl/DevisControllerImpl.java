package com.example.springrestful_digitalorders.Controllers.impl;

import com.example.springrestful_digitalorders.Controllers.DevisController;
import com.example.springrestful_digitalorders.Repositories.DevisRepository;
import com.example.springrestful_digitalorders.Services.DevisService;
import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/devis")
public class DevisControllerImpl implements DevisController {

    private final DevisService devisService;
    private final DevisRepository devisRepository;

    /*@PostMapping("/save")
    public ResponseEntity<Devis> generateDevis(@RequestBody Devis devis){
        Devis devis1 = devisService.addDevis(devis);

        if (devis1 != null) {
            return ResponseEntity.status(HttpStatus.OK).body(devis1);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }*/

    @Override
    public ResponseEntity<Devis> generateDevis(Devis devis) {
        return null;
    }

    @GetMapping("/")
    public List<Devis> findAll() {
        return devisService.findAll();
    }

    @GetMapping("/c")
    public List<Devis> findAllWithNonNullDateCreation() {
        return devisRepository.findAllWithNonNullDateCreation();
    }

    @GetMapping("/showAll/{id}")
    public Map<String, String> showDevis(@PathVariable Long id){
        return devisService.showDevis(id);
    }

    @PostMapping("/updateStatus/{id}")
    public Devis updateStatus(@PathVariable Long id, @RequestBody DevisStatus devisStatus){
        return devisService.updateStatus(id,devisStatus);
    }

    @PostMapping("/updateDevis/{id}")
    public Devis updateDevis(@PathVariable Long id,@RequestBody Double discount){
        return devisService.updateDevis(id,discount);
    }

}
