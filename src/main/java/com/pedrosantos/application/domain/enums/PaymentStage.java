package com.pedrosantos.application.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStage {

	PENDING(1, "Pendente"),
	DONE(2, "Realizado"),
	CANCELED(2, "Cancelado");
	
	private int cod;
	private String description;
	
	public static PaymentStage toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (PaymentStage payment : PaymentStage.values()) {
			if (cod.equals(payment.getCod())) {
				return payment;
			}
		}
		
		throw new IllegalArgumentException("ID inválido: " + cod);
	}
}
