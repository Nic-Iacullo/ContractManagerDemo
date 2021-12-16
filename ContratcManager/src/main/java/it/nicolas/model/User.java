package it.nicolas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String email;
	private String phone;
	private String adress;
	@OneToOne
	private UserType type;

	public User() {
	}

	public User(String name, String email, String phone, String adress, UserType type) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.type = type;
	}

}
