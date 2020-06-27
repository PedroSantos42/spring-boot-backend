package com.pedrosantos.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PurchaseProductPK id = new PurchaseProductPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public PurchaseProduct() {
	}
	
	public PurchaseProduct(Product product, Purchase purchase, Double discount, Integer quantity, Double price) {
		super();
		id.setProduct(product);
		id.setPurchase(purchase);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Purchase getPurchase() {
		return id.getPurchase();
	}

	public Product getProduct() {
		return id.getProduct();
	}
	
	public PurchaseProductPK getId() {
		return id;
	}

	public void setId(PurchaseProductPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		PurchaseProduct other = (PurchaseProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
