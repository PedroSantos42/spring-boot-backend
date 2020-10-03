package com.pedrosantos.application.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
	private String email;
	private String cpfCnpj;
	private Integer type;
	
	private String street;
	private String number;
	private String complement;
	private String district;
	private String zipCode;

	private String telephone1;
	private String telephone2;
	private String telephone3;
	
	private Integer cityId;
}
