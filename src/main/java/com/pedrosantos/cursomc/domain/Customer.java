package com.pedrosantos.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedrosantos.cursomc.domain.enums.CustomerType;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Email
	private String email;
	@NotEmpty
	private String cpf_cnpj;
	private Integer type;

	@OneToMany(mappedBy = "customer")
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEPHONE")
	private Set<String> telephones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Purchase> purchases = new ArrayList<>();

	public Customer() {
	}

	public Customer(Integer id, String name, String email, String cpf_cnpj, CustomerType type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf_cnpj = cpf_cnpj;
		this.type = type.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public CustomerType getType() {
		return CustomerType.toEnum(type);
	}

	public void setType(CustomerType type) {
		this.type = type.getCod();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(Set<String> telephones) {
		this.telephones = telephones;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setOrders(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
