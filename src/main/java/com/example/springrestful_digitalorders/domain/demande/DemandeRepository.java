package com.example.springrestful_digitalorders.domain.demande;

import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository <Equipement, Integer> {
}
