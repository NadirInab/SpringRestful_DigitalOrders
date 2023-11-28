package com.example.springrestful_digitalorders.application.contract;

import com.example.springrestful_digitalorders.domain.contract.Contract;
import com.example.springrestful_digitalorders.domain.contract.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
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
    public Contract save(Contract contract) {
        if (contract.getDevis().getStatus().equals("accepted")) {
            return contractRepository.save(contract);
        } else {
            throw new RuntimeException("Devis not accepted");
        }
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
        contract.setArchived(true);
        return contractRepository.save(contract);
    }
}
