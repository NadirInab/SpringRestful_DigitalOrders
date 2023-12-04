package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

    public Equipement findByName(String name) ;

    public List<Equipement> findAll() ;

    public Optional<Equipement> findById(Long id) ;
}
