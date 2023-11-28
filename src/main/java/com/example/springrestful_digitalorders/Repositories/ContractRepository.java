package com.example.springrestful_digitalorders.Repositories;

import com.example.springrestful_digitalorders.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT c FROM Contract c WHERE c.endDate >= CURRENT_DATE")
    List<Contract> findActiveContracts();

    @Query("SELECT c FROM Contract c WHERE c.endDate < CURRENT_DATE")
    List<Contract> findArchivedContracts();
}