package it.nicolas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nicolas.model.Contract;
import it.nicolas.model.ContractType;
import it.nicolas.model.UserType;

public interface ContractRepository extends JpaRepository<Contract, Long> {
	List<Contract> findByCustomerName(String customerName);
	List<Contract> findByDateStart(LocalDate date);
	List<Contract> findByType(ContractType contractType);
	List<Contract> findByCustomerType(UserType customerType);
	List<Contract> findByCustomerId(Long id);
	
	//SEARCH WITH COMBINED FILTERS
	List<Contract> findByCustomerNameAndDateStart(String name,LocalDate date);
	List<Contract> findByCustomerNameAndTypeId(String name,Long id);
	List<Contract> findByDateStartAndTypeId(LocalDate date,Long id);
	List<Contract> findByDateStartAndCustomerTypeId(LocalDate date,Long id);
}
