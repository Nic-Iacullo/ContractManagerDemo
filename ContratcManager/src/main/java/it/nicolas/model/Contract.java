package it.nicolas.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "contratcs")
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private ContractType type;
	private LocalDate dateStart;
	private Double rateEnergy;
	private Double rateGas;
	@ManyToOne
	private User customer;

	public Contract() {
	}

	public Contract(ContractType type, LocalDate dateStart, User customer) {
		super();
		this.type = type;
		this.dateStart = dateStart;
		this.customer = customer;
	}

	public Contract(ContractType type, LocalDate dateStart, Double rateEnergy, Double rateGas, User customer) {
		super();
		this.type = type;
		this.dateStart = dateStart;
		this.rateEnergy = rateEnergy;
		this.rateGas = rateGas;
		this.customer = customer;
	}

}
