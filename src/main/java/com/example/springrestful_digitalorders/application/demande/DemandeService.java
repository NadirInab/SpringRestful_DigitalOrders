package com.example.springrestful_digitalorders.application.demande;

import com.example.springrestful_digitalorders.domain.demande.Demande;
import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeService {

    public List<Equipement> findAll() ;
    public Equipement findById(Long id) ;

    //public Demande save(Demande demande);

    public void deleteById(Long id);
    public void delete(Demande demande);
}
