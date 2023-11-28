package com.example.springrestful_digitalorders.domain.equipement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

    public Equipement findByName(String name) ;
}
