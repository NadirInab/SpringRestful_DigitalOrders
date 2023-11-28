package com.example.springrestful_digitalorders.Dtos;

import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Devis}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevisDto implements Serializable {
    Long id;
    DevisStatus devisStatus;
    Date dateCreation;
    Date dateExpiration;

    public static DevisDto toDto(Devis devis){
        return DevisDto.builder()
                .id(devis.getId())
                .devisStatus(devis.getDevisStatus())
                .dateCreation(devis.getDateCreation())
                .dateExpiration(devis.getDateExpiration())
                .build();
    }
}