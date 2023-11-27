package com.example.springrestful_digitalorders.infrastructure.contract;

import com.example.springrestful_digitalorders.application.contract.ContractService;
import com.example.springrestful_digitalorders.domain.contract.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController{

        private final ContractService contractService;

        @Autowired
        public ContractControllerImpl(ContractService contractService) {
            this.contractService = contractService;
        }

        @GetMapping
        public ResponseEntity<List<Contract>> getAllContracts() {
            List<Contract> contracts = contractService.findAll();
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
            try {
                Contract contract = contractService.findById(id);
                return new ResponseEntity<>(contract, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping
        public ResponseEntity<?> createContract(@RequestBody Contract contract) {
            try {
                Contract savedContract = contractService.save(contract);
                return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateContract(@PathVariable Long id, @RequestBody Contract contract) {
            try {
                Contract updatedContract = contractService.update(contract);
                return new ResponseEntity<>(updatedContract, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
            contractService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
