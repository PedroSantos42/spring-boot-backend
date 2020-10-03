package com.pedrosantos.application.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class PurchaseProductPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
