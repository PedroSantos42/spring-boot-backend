package com.pedrosantos.application.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PurchaseProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PurchaseProductPK id = new PurchaseProductPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
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
}
