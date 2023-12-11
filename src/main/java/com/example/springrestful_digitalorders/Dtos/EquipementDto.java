package com.example.springrestful_digitalorders.Dtos;

import com.example.springrestful_digitalorders.entities.Equipement;
import com.example.springrestful_digitalorders.entities.EquipementStatus;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Equipement}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipementDto implements Serializable {
    Long id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    String name;
    @NotNull(message = "dailyRentalCost cannot be null")
    Double dailyRentalCost;
    UUID uuid;
    @NotNull
    EquipementStatus status;


    public static EquipementDto toDto(Equipement equipement){
        return EquipementDto.builder()
                .id(equipement.getId())
                .name(equipement.getName())
                .dailyRentalCost(equipement.getDailyRentalCost())
                .uuid(equipement.getUuid())
                .status(equipement.getStatus())
                .build();
    }
}