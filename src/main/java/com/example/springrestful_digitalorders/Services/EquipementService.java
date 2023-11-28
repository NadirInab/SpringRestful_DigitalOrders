package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipementService {

    public Equipement save(Equipement equipement);

    public List<Equipement> findAll();

    public Equipement findByName(String name);
}
