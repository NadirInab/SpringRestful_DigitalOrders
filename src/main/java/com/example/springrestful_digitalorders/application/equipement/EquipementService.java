package com.example.springrestful_digitalorders.application.equipement;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EquipementService {

    public Equipement save(Equipement equipement);

    public List<Equipement> findAll();

    public Equipement findByNameAndUuid(String name, UUID uuid);
}
