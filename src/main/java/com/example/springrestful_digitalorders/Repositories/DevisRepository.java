package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<Devis,Long> {
}
