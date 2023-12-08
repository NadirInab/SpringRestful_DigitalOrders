package com.example.springrestful_digitalorders.Services.impl;

import com.example.springrestful_digitalorders.Services.ContractService;
import com.example.springrestful_digitalorders.entities.Contract;
import com.example.springrestful_digitalorders.Repositories.ContractRepository;
import com.example.springrestful_digitalorders.entities.Devis;
import com.example.springrestful_digitalorders.entities.DevisStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract not found"));
    }

    @Override
    public Contract save(Devis devis) {
        if (devis.getDevisStatus() != DevisStatus.ACCEPTED) {
            throw new IllegalArgumentException("This request is not accepted");
        } else if (devis.getDevisStatus() != DevisStatus.REJECTED) {
            throw new IllegalArgumentException("This request is Rejected");
        }
        Contract contract = new Contract();

        contract.setDevis(devis);
        contract.setIsArchived(false);

        return contractRepository.save(contract);
    }
    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    @Override
    public Contract update(Contract contract) {
        return contractRepository.save(contract);
    }

    public List<Contract> getActiveContracts() {
        return contractRepository.findActiveContracts();
    }

    public List<Contract> getArchivedContracts() {
        return contractRepository.findArchivedContracts();
    }

    public Contract archiveContract(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract not found"));
        contract.setIsArchived(true);
        return contractRepository.save(contract);
    }

    public Contract activateContract(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract not found"));
        contract.setIsArchived(false);
        return contractRepository.save(contract);
    }
}
