package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.Repositories.DevisRepository;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DevisServiceImpl implements DevisService {

    DevisRepository devisRepository;
    @Override
    public Devis addDevis(Devis devis) {

        if (devis.getDemande().getDemandeStatus() != DemandeStatus.ACCEPTED) {
            throw new IllegalArgumentException("This request is not accepted");
        }
        devis.setDevisStatus(DevisStatus.PENDDING);

        Date currentDate = Calendar.getInstance().getTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 48);

        devis.setDateCreation(currentDate);
        devis.setDateExpiration(calendar.getTime());


        return devisRepository.save(devis);
    }

    @Override
    public List<Devis> findAll() {
        return devisRepository.findAll();
    }


    private int calculateNumberOfDays(Date startDate, Date endDate) {
        long timeDifference = endDate.getTime() - startDate.getTime();

        int daysDifference = (int) (timeDifference / (1000 * 60 * 60 * 24));

        return daysDifference;
    }
}
