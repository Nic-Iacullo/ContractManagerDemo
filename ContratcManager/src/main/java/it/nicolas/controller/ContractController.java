package it.nicolas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.nicolas.model.Contract;
import it.nicolas.model.ContractType;
import it.nicolas.model.UserType;
import it.nicolas.service.ContractService;

@RestController
@RequestMapping(value = "/api")
public class ContractController {
	@Autowired
	ContractService service;
	
	@PostMapping(value = "/contract/save")
	public ResponseEntity<Contract> save(@RequestBody Contract contract) {
		return new ResponseEntity<>(service.saveContract(contract),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/contract/update")
	public ResponseEntity<Contract> update(@RequestBody Contract contract) {
		return new ResponseEntity<>(service.updateContract(contract),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/contract/delete")
	public ResponseEntity<String> delete(@RequestParam Long id){
		service.deleteContract(id);
		return new ResponseEntity<>("Contratto eleminato con successo",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/contract/name")
	List<Contract> findByCustomerName(@RequestParam String customerName){
		return service.findByCustomerName(customerName);
	}
	@GetMapping(value = "/contract/date")
	List<Contract> findByDateStart(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date){
		return service.findByDateStart(date);
	}
	@PostMapping(value = "/contract/type")
	List<Contract> findByType(@RequestBody ContractType contractType){
		return service.findByType(contractType);
	}
	@PostMapping(value = "/contract/typecustomer")
	List<Contract> findByCustomerType(@RequestBody UserType customerType){
		return service.findByCustomerType(customerType);
	}
	
	@GetMapping(value = "/contract/id")
	List<Contract> findByCustomerId(@RequestParam Long id){
		return service.findByCustomerId(id);
	}

	//SEARCH WITH COMBINED FILTERS
	@GetMapping(value = "/contract/namedate")
	List<Contract> findByCustomerNameAndDateStart(@RequestParam String name,@DateTimeFormat(iso = ISO.DATE) LocalDate date){
		return service.findByCustomerNameAndDateStart(name, date);
	}
	@GetMapping(value = "/contract/namecontrac")
	List<Contract> findByCustomerNameAndTypeContractType(@RequestParam String name,Long id){
		return service.findByCustomerNameAndTypeId(name, id);
	}
	@GetMapping(value = "/contract/datecontract")
	List<Contract> findByDateStartAndTypeContractType(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,Long id){
		return service.findByDateStratAndTypeId(date, id);
	}
	@GetMapping(value = "/contract/datecustomer")
	List<Contract> findByDateStartAndCustomerTypeId(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,Long id){
		return service.findByDateStartAndCustomerTypeId(date, id);
	}
	
}
