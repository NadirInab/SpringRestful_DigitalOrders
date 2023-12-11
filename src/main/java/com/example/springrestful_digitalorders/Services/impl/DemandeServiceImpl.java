package com.example.springrestful_digitalorders.Services.impl;

import com.example.springrestful_digitalorders.Services.DemandeService;
import com.example.springrestful_digitalorders.Services.DevisService;
import com.example.springrestful_digitalorders.entities.*;
import com.example.springrestful_digitalorders.Repositories.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl  implements DemandeService {


    private  final DemandeRepository demandeRepository;

    private final DevisService devisService;
    @Override
    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande findById(Long id) {
        return demandeRepository.findById(id).orElseThrow(() -> new RuntimeException("demande not found"));
    }
    @Override
   public Demande save(Demande demande) {
    return demandeRepository.save(demande) ;
    }

    @Override
    public void deleteById(Long id) {
        demandeRepository.deleteById(id);
    }

    @Override
    public void delete(Demande demande) {
        demandeRepository.delete(demande);
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

    @Override
    public Devis updateDemandeStatus(Long id, DemandeStatus demandeStatus) {
        Demande demande = demandeRepository.findById(id).get();
        demande.setDemandeStatus(demandeStatus);
        demandeRepository.save(demande);
        return devisService.addDevis(demande);

    }



}
