package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DevisRepository extends JpaRepository<Devis,Long> {

    @Query("SELECT d FROM Devis d WHERE d.dateCreation IS NOT NULL")
    List<Devis> findAllWithNonNullDateCreation();
}
