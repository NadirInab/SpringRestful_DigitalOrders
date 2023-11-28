package com.example.springrestful_digitalorders.application.demande;

import com.example.springrestful_digitalorders.domain.demande.Demande;
import com.example.springrestful_digitalorders.domain.demande.DemandeRepository;
import com.example.springrestful_digitalorders.domain.equipement.Equipement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DemandeServiceImpl  implements DemandeService {


    private  DemandeRepository demandeRepository;

    @Override
    public List<Equipement> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Equipement findById(Long id) {
        return demandeRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("demande not found"));
    }

    //@Override
  //  public Demande save(Demande demande) {
     //       return demandeRepository.save(demande) ;
   // }

    @Override
    public void deleteById(Long id) {
        demandeRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void delete(Demande demande) {
        demandeRepository.delete(demande.getEquipement());
    }
}
