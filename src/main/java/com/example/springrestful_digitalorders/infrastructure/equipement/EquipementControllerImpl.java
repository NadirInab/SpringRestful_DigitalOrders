package com.example.springrestful_digitalorders.infrastructure.equipement;


import com.example.springrestful_digitalorders.application.equipement.EquipementService;
import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/equipements")
public class EquipementControllerImpl {

    private EquipementService equipementService;

    @Autowired
    public void EquipementControllerImp(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping("/save")
    public Equipement saveEquipement(@RequestBody Equipement equipement) {
        return equipementService.save(equipement);
    }

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.findAll();
    }

    @GetMapping("/{name}/{uuid}")
    public Equipement getEquipementByNameAndUuid(@PathVariable String name) {
        return equipementService.findByName(name);
    }
}
