package com.example.springrestful_digitalorders.application.equipement;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import com.example.springrestful_digitalorders.domain.equipement.EquipementRepository;
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
