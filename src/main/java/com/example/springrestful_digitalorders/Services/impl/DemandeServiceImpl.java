package com.example.springrestful_digitalorders.Services.impl;

import com.example.springrestful_digitalorders.Services.DemandeService;
import com.example.springrestful_digitalorders.entities.Demande;
import com.example.springrestful_digitalorders.Repositories.DemandeRepository;
import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Equipement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl  implements DemandeService {


    private  DemandeRepository demandeRepository;
    @Autowired
    public DemandeServiceImpl(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }
    @Override
    public List<Equipement> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Equipement findById(Long id) {
        return demandeRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("demande not found"));
    }
    @Override
   public Demande save(Demande demande) {
    return demandeRepository.save(demande) ;
    }

    @Override
    public void deleteById(Long id) {
        demandeRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void delete(Demande demande) {
        demandeRepository.delete(demande.getEquipement());
    }

    @Override
    public List<Demande> getPendingDemands() {
        List<DemandeStatus> pendingStatuses = Arrays.asList(
                DemandeStatus.PENDING,
                DemandeStatus.ACCEPTED,
                DemandeStatus.REJECTED,
                DemandeStatus.CANCEL
        );

        return demandeRepository.findByDemandeStatusIn(pendingStatuses);
    }
}
