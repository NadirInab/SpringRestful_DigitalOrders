package com.example.springrestful_digitalorders.application.devis;

import com.example.springrestful_digitalorders.domain.demande.DemandeStatus;
import com.example.springrestful_digitalorders.domain.devis.Devis;
import com.example.springrestful_digitalorders.domain.devis.DevisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService{

    DevisRepository devisRepository;
    @Override
    public Devis generateDevis(Devis devis) {
        if (devis.getDemande().getDemandeStatus() != DemandeStatus.ACCEPTED) {
            throw new IllegalArgumentException("This request is not accepted");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 48);

        devis.setDateExpiration(calendar.getTime());
        return devisRepository.save(devis);
    }
}
