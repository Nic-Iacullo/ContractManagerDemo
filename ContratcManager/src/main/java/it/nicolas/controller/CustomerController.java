package it.nicolas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.nicolas.model.User;
import it.nicolas.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
	@Autowired
	UserService service;

	@PostMapping(value = "/customer/save")
	public ResponseEntity<String> save(@RequestBody User customer) {
		service.saveCustomer(customer);
		return new ResponseEntity<>("Customer successfully saved", new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/customer/update")
	public ResponseEntity<String> update(@RequestBody User customer) {
		service.updateCustomer(customer);
		return new ResponseEntity<>("Customer successfully updated", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/customer/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) {
		service.deleteCustomer(id);
		return new ResponseEntity<>("Customer successfully deleted", new HttpHeaders(), HttpStatus.OK);
	}
}
