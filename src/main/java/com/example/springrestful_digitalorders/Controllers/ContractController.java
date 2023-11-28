package com.example.springrestful_digitalorders.Controllers;

import com.example.springrestful_digitalorders.entities.Contract;
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
