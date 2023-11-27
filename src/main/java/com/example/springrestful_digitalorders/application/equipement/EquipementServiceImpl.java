package com.example.springrestful_digitalorders.application.equipement;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import com.example.springrestful_digitalorders.domain.equipement.EquipementRepository;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
import org.springframework.stereotype.Component;
>>>>>>> f7be5afabbb432a68dcc4a6c40dc1e9b0c91b8e3

import java.util.List;
import java.util.UUID;


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
