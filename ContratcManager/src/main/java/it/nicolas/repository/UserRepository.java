package it.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nicolas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
