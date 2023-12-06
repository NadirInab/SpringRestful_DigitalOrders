package com.example.springrestful_digitalorders.Controllers.impl;


import com.example.springrestful_digitalorders.Services.DemandeService;
import com.example.springrestful_digitalorders.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/demande")
public class DemandControllerImpl {

    private DemandeService demandeService ;

    @Autowired
    public void DemandControllerImpl(DemandeService demandeService){
        this.demandeService = demandeService ;
    }

    @GetMapping("/")
    public List<Demande> getAllDemandes() {
        return demandeService.findAll();
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Demande>> getDemandeByStatus() {
        try {
            List<Demande> pendingDemands = demandeService.getPendingDemands();
            return new ResponseEntity<>(pendingDemands, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}")
    public Demande getDemandeById(@PathVariable Long id) {
        return demandeService.findById(id);
    }

    @PostMapping("/save")
    public Demande createDemande(@RequestBody Demande demande) {
        return demandeService.save(demande);
    }

    @DeleteMapping("/{id}")
    public void deleteDemandeById(@PathVariable Long id) {
        demandeService.deleteById(id);
    }

    @DeleteMapping
    public void deleteDemande(@RequestBody Demande demande) {
        demandeService.delete(demande);
    }

    @PostMapping("/updateDemande/{id}")
    public Devis updateDemande(@PathVariable Long id, @RequestBody DemandeStatus demandeStatus){
        return demandeService.updateDemandeStatus(id,demandeStatus);
    }

    }
