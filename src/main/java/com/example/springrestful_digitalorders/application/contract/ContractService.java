package com.example.springrestful_digitalorders.application.contract;

import com.example.springrestful_digitalorders.domain.contract.Contract;
import com.example.springrestful_digitalorders.domain.contract.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService{
    public List<Contract> findAll();
    public Contract findById(Long id);
    public Contract save(Contract contract);
    public void deleteById(Long id);
    public void delete(Contract contract);
    public Contract update(Contract contract);

    public List<Contract> getActiveContracts();
    public List<Contract> getArchivedContracts();
    public Contract archiveContract(Long id);
}
