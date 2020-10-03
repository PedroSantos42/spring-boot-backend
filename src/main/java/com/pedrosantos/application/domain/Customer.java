package com.pedrosantos.application.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedrosantos.application.domain.enums.CustomerType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String name;
	@Email
	private String email;
	private String cpfCnpj;
	private Integer type;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEPHONE")
	private Set<String> telephones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Purchase> purchases = new ArrayList<>();

	public Customer(Integer id, String name, String email, String cpfCnpj, CustomerType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.type = (type == null) ? null : type.getCod();
	}

	public CustomerType getType() {
		return CustomerType.toEnum(type);
	}

	public void setType(CustomerType type) {
		this.type = type.getCod();
	}
}
