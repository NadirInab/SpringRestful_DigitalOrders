package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Demande;
import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository <Demande, Long> {

    public Demande save(Demande demande) ;

    @Query("SELECT d FROM Demande d WHERE d.demandeStatus IN :statusList")
    List<Demande> findByDemandeStatusIn(@Param("statusList") List<DemandeStatus> statusList);
}
