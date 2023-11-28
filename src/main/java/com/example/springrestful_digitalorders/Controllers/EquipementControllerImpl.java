package com.example.springrestful_digitalorders.Controllers;


import com.example.springrestful_digitalorders.Services.EquipementService;
import com.example.springrestful_digitalorders.entities.Equipement;
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

    @GetMapping("/{name}")
    public Equipement getEquipementByNameAndUuid(@PathVariable String name) {
        return equipementService.findByName(name);
    }
}
