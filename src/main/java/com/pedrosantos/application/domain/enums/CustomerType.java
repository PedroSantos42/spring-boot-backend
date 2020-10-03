package com.pedrosantos.application.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerType {

	CIVILIAN(1, "Pessoa Física"), JURIDICAL(2, "Pessoa Jurídica");

	private int cod;
	private String description;

	public static CustomerType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (CustomerType customer : CustomerType.values()) {
			if (cod.equals(customer.getCod())) {
				return customer;
			}
		}

		throw new IllegalArgumentException("ID inválido: " + cod);
	}
}
