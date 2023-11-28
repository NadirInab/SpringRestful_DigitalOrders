package com.example.springrestful_digitalorders.infrastructure.contract;

import com.example.springrestful_digitalorders.domain.contract.Contract;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ContractController {
    public List<Contract> getAllContracts();
    public Contract getContractById(Long id);
    public Contract createContract(Contract contract);
    public Contract updateContract(Long id, Contract contract);
    public void deleteContract(Long id);

    public List<Contract> getActiveContracts();
    public List<Contract> getArchivedContracts();
}
