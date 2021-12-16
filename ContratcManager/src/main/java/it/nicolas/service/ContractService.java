package it.nicolas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.nicolas.model.Contract;
import it.nicolas.model.ContractType;
import it.nicolas.model.UserType;
import it.nicolas.model.EContract;
import it.nicolas.repository.ContractRepository;
import it.nicolas.repository.ContractTypeRepository;

@Service
public class ContractService {
	@Autowired
	ContractRepository contract;
	@Autowired
	ContractTypeRepository type;
	@Value("${rate_energy}")
	private Double rateEnergy;
	@Value("${rate_gas}")
	private Double rateGas;

	public void saveType(ContractType contractType) {
		if(type.findByContractType(contractType.getContractType())==null)
			type.save(contractType);
	}

	public void deleteType(Long id) {
		type.deleteById(id);
	}

	public void updateType(ContractType contractType) {
		if (type.findById(contractType.getId()).isPresent()) {
			ContractType data = type.getById(contractType.getId());
			data.setContractType(contractType.getContractType());
			type.save(data);
		}
	}

	public Contract saveContract(Contract c) {
		if(c.getType().getContractType().equals(EContract.ELETRICITY)) {
			c.setRateEnergy(rateEnergy);
		}else if(c.getType().getContractType().equals(EContract.GAS)) {
			c.setRateGas(rateGas);
		}else {
			c.setRateEnergy(rateEnergy);
			c.setRateGas(rateGas);
		}
		return contract.save(c);
	}

	public Contract updateContract(Contract c) {
		if (contract.findById(c.getId()).isPresent()) {
			Contract data = contract.getById(c.getId());
			data.setCustomer(c.getCustomer());
			data.setDateStart(c.getDateStart());
			data.setType(c.getType());
			if(c.getType().getContractType().equals(EContract.ELETRICITY)) {
				c.setRateEnergy(rateEnergy);
			}else if(c.getType().getContractType().equals(EContract.GAS)) {
				c.setRateGas(rateGas);
			}else {
				c.setRateEnergy(rateEnergy);
				c.setRateGas(rateGas);
			}
			return contract.save(data);
		}
		return new Contract();
	}

	public void deleteContract(Long id) {
		contract.deleteById(id);
	}

	public List<Contract> findByCustomerId(Long id) {
		return contract.findByCustomerId(id);
	}

	public List<Contract> findByCustomerName(String customerName) {
		return contract.findByCustomerName(customerName);
	}

	public List<Contract> findByDateStart(LocalDate date) {
		return contract.findByDateStart(date);
	}

	public List<Contract> findByType(ContractType contractType) {
		return contract.findByType(contractType);
	}

	public List<Contract> findByCustomerType(UserType customerType) {
		return contract.findByCustomerType(customerType);
	}
	
	
		//SEARC WITH COMBINED FILTERS
	public List<Contract> findByCustomerNameAndDateStart(String name,LocalDate date){
		return contract.findByCustomerNameAndDateStart(name, date);
	}
	public List<Contract> findByCustomerNameAndTypeId(String name,Long id ){
		return contract.findByCustomerNameAndTypeId(name, id);
	}
	public List<Contract> findByDateStratAndTypeId(LocalDate date,Long id){
		return contract.findByDateStartAndTypeId(date, id);
	}
	public List<Contract> findByDateStartAndCustomerTypeId(LocalDate date,Long id){
		return contract.findByDateStartAndCustomerTypeId(date, id);
	}
}
