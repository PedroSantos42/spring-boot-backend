package com.pedrosantos.cursomc.domain.enums;

public enum CustomerType {

	CIVILIAN(1, "Pessoa Física"), JURIDICAL(2, "Pessoa Jurídica");

	private int cod;
	private String description;

	private CustomerType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

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
