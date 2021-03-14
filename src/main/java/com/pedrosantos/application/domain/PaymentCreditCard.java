package com.pedrosantos.application.domain;

import javax.persistence.Entity;

import com.pedrosantos.application.domain.enums.PaymentStatus;

@Entity
public class PaymentCreditCard extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer installments;
	
	public PaymentCreditCard() {}

	public PaymentCreditCard(Integer id, PaymentStatus paymentStatus, Purchase order, Integer installments) {
		super(id, paymentStatus, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
}
