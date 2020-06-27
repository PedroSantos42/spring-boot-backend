package com.pedrosantos.cursomc.domain.enums;

public enum PaymentStage {

	PENDING(1, "Pendente"),
	DONE(2, "Realizado"),
	CANCELED(2, "Cancelado");
	
	private int cod;
	private String description;
	
	private PaymentStage(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
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
