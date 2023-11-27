package com.example.springrestful_digitalorders.application.equipement;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import com.example.springrestful_digitalorders.domain.equipement.EquipementRepository;

import java.util.List;

public class EquipementServiceImpl implements EquipementService{

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement save(Equipement equipement) {
            return equipementRepository.save(equipement);
        throw new IllegalArgumentException("Equipement is not valid");
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }
}
