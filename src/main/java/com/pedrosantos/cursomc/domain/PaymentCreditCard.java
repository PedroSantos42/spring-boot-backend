package com.pedrosantos.cursomc.domain;

import javax.persistence.Entity;

import com.pedrosantos.cursomc.domain.enums.PaymentStage;

@Entity
public class PaymentCreditCard extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer installments;
	
	public PaymentCreditCard() {}

	public PaymentCreditCard(Integer id, PaymentStage stage, Purchase order, Integer installments) {
		super(id, stage, order);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
}
