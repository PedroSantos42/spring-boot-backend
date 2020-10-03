package com.pedrosantos.application.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String streetName;
	private String number;
	private String complement;
	private String district;
	private String zipCode;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public Address(Integer id, String streetName, String number, String complement, String district, String zipCode,
			Customer customer, City city) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.zipCode = zipCode;
		this.customer = customer;
		this.setCity(city);
	}
}
