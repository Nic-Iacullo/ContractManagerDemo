package it.nicolas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nicolas.model.ContractType;
import it.nicolas.model.UserType;
import it.nicolas.model.EContract;
import it.nicolas.model.EUser;
import it.nicolas.service.ContractService;
import it.nicolas.service.UserService;
@Component
public class ManagerRunner implements CommandLineRunner {
@Autowired
UserService customerService;
@Autowired
ContractService contractService; 
	@Override
	public void run(String... args) throws Exception {
		customerService.saveType(new UserType(EUser.BUSINESS));
		customerService.saveType(new UserType(EUser.PRIVATE));
		
		contractService.saveType(new ContractType(EContract.BOTH));
		contractService.saveType(new ContractType(EContract.ELETRICITY));
		contractService.saveType(new ContractType(EContract.GAS));
	}

}
