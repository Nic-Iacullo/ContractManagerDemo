package it.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nicolas.model.ContractType;
import it.nicolas.model.EContract;

public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {
	ContractType findByContractType(EContract contractType);
}
