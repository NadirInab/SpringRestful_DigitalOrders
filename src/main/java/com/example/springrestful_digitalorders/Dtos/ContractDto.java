package com.example.springrestful_digitalorders.Dtos;

import com.example.springrestful_digitalorders.entities.Contract;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.Entity;

import java.io.Serializable;

/**
 * DTO for {@link Contract}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDto implements Serializable {
    Long id;
    @NotNull
    DevisDto devis;
    Boolean isArchived;

    public static ContractDto toDto(Contract contract){
        return ContractDto.builder()
                .id(contract.getId())
                .devis(DevisDto.toDto(contract.getDevis()))
                .isArchived(contract.getIsArchived())
                .build();
    }
}