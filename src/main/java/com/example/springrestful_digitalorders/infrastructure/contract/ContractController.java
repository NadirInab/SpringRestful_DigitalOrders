package com.example.springrestful_digitalorders.infrastructure.contract;

import com.example.springrestful_digitalorders.domain.contract.Contract;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ContractController {
    public ResponseEntity<List<Contract>> getAllContracts();
    public ResponseEntity<Contract> getContractById(Long id);
    public ResponseEntity<?> createContract(Contract contract);
    public ResponseEntity<?> updateContract(Long id, Contract contract);
    public ResponseEntity<Void> deleteContract(Long id);
}
