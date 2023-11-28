package com.example.springrestful_digitalorders.Dtos;

import com.example.springrestful_digitalorders.Dtos.UserDto;
import com.example.springrestful_digitalorders.entities.Demande;
import com.example.springrestful_digitalorders.entities.DemandeStatus;
import com.example.springrestful_digitalorders.entities.Equipement;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Demande}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemandeDto implements Serializable {
    Long id;
    Date startDate;
    Date endDate;
    Date createdAt;
    DemandeStatus demandeStatus;
    UserDto user;
    @NotNull
    Equipement equipement;

    public static DemandeDto toDto(Demande demande){
        return DemandeDto.builder()
                .id(demande.getId())
                .startDate(demande.getStartDate())
                .endDate(demande.getEndDate())
                .createdAt(demande.getCreatedAt())
                .demandeStatus(demande.getDemandeStatus())
                .user(UserDto.toDto(demande.getUser()))
                .equipement(demande.getEquipement())
                .build();
    }
}