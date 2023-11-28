package com.example.springrestful_digitalorders.Controllers.impl;

import com.example.springrestful_digitalorders.Controllers.ContractController;
import com.example.springrestful_digitalorders.Services.ContractService;
import com.example.springrestful_digitalorders.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController {

        private final ContractService contractService;

        @Autowired
        public ContractControllerImpl(ContractService contractService) {
            this.contractService = contractService;
        }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.findAll();
    }

    @GetMapping("/{id}")
    public Contract getContractById(@PathVariable Long id) {
        return contractService.findById(id);
    }

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractService.save(contract);
    }

    @PutMapping("/{id}")
    public Contract updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        return contractService.update(contract);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteById(id);
    }

    @GetMapping("/active")
    public List<Contract> getActiveContracts() {
        return contractService.getActiveContracts();
    }

    @GetMapping("/archived")
    public List<Contract> getArchivedContracts() {
        return contractService.getArchivedContracts();
    }
}
