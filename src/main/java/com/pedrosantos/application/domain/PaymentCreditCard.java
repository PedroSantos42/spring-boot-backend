package com.pedrosantos.application.domain;

import javax.persistence.Entity;

import com.pedrosantos.application.domain.enums.PaymentStage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class PaymentCreditCard extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Integer installments;
	
	public PaymentCreditCard(Integer id, PaymentStage stage, Purchase order, Integer installments) {
		super(id, stage, order);
		this.installments = installments;
	}
}
