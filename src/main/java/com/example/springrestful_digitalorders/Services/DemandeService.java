package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Demande;
import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.entities.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeService {

    public List<Demande> findAll() ;
    public Demande findById(Long id) ;

    public Demande save(Demande demande);

    public void deleteById(Long id);
    public void delete(Demande demande);

    List<Demande> getPendingDemands();

    public Devis updateDemandeStatus(Long id, DemandeStatus demandeStatus);

}
