package it.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nicolas.model.UserType;
import it.nicolas.model.EUser;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
	UserType findByCustomerType(EUser customerType);
}
