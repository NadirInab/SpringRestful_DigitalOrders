package com.example.springrestful_digitalorders.Services.impl;

import com.example.springrestful_digitalorders.Services.DevisService;
import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.Repositories.DevisRepository;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

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


    public void updateDevis(Devis devis) {
        Discount(devis);
        devisRepository.save(devis);
    }


    private int calculateNumberOfDays(Date startDate, Date endDate) {
        long timeDifference = endDate.getTime() - startDate.getTime();


        int daysDifference = (int) (timeDifference / (1000 * 60 * 60 * 24));

        return daysDifference;
    }

    private void Discount(Devis devis) {
        Double discount = devis.getDiscount();
        if (discount == null || discount < 0) {
            throw new IllegalArgumentException("Invalid discount. Please provide a valid non-negative double value.");
        }
    }

    public Map<String, String> showDevis(Devis devis) {
        Map<String, String> devis1 = new HashMap<>();

        Double price = devis.getDemande().getEquipement().getDailyRentalCost();
        Double discount = devis.getDiscount();
        Double priceAfter = discount == 0 ? price : (price * discount) / 100;

        devis1.put("id", devis.getId().toString());
        devis1.put("Equipement", devis.getDemande().getEquipement().getName());
        devis1.put("Start Date", devis.getDemande().getStartDate().toString());
        devis1.put("End Date", devis.getDemande().getEndDate().toString());
        devis1.put("Old Price", price.toString());
        devis1.put("New price", priceAfter.toString());

        return devis1;
    }


}
