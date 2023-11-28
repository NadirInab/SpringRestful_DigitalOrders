package com.example.springrestful_digitalorders.Services.impl;

import com.example.springrestful_digitalorders.Services.EquipementService;
import com.example.springrestful_digitalorders.entities.Equipement;
import com.example.springrestful_digitalorders.Repositories.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement save(Equipement equipement) {
            return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    public Equipement findByName(String name){
        return equipementRepository.findByName(name) ;
    }
}
