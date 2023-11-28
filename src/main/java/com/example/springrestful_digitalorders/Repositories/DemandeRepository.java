package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository <Equipement, Integer> {
}
