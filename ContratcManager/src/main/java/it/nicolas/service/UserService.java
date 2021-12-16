package it.nicolas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nicolas.model.User;
import it.nicolas.model.UserType;
import it.nicolas.repository.UserRepository;
import it.nicolas.repository.UserTypeRepository;

@Service
public class UserService {
	@Autowired
	UserRepository customer;

	@Autowired
	UserTypeRepository type;

	public void saveType(UserType customerType) {
		if (type.findByCustomerType(customerType.getCustomerType()) == null)
			type.save(customerType);
	}

	public void deleteType(Long id) {
		type.deleteById(id);
	}

	public void updateType(UserType customerType) {
		if (type.findById(customerType.getId()).isPresent()) {
			UserType data = type.getById(customerType.getId());
			data.setCustomerType(customerType.getCustomerType());
			type.save(customerType);
		}
	}

	public void saveCustomer(User c) {
		customer.save(c);
	}

	public void deleteCustomer(Long id) {
		customer.deleteById(id);
	}

	public void updateCustomer(User c) {
		if (customer.findById(c.getId()).isPresent()) {
			User data = customer.getById(c.getId());
			data.setName(c.getName());
			data.setEmail(c.getEmail());
			data.setAdress(c.getAdress());
			data.setPhone(c.getPhone());
			customer.save(data);
		}
	}
}
