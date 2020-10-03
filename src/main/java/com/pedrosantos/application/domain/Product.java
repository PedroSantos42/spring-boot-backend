package com.pedrosantos.application.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name = "PRODUCT_CATEGORY", 
		joinColumns = @JoinColumn(name = "product_id"), 
		inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private List<Category> categories = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	private Set<PurchaseProduct> items = new HashSet<>();
	
	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@JsonIgnore
	public List<Purchase> getPurchases() {
		List<Purchase> list = new ArrayList<>();
		for(PurchaseProduct p : items) {
			list.add(p.getPurchase());
		}
		return list;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
