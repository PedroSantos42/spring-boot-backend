package com.pedrosantos.application.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.pedrosantos.application.service.validations.CustomerInsert;

@CustomerInsert
public class CustomerNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
	
    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;

	@NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpfCnpj;
	
	private Integer type;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String street;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String number;
	private String complement;
	private String district;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String zipCode;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String telephone1;
	
	private String telephone2;
	private String telephone3;
	
	private Integer cityId;
	
	public CustomerNewDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getTelephone3() {
		return telephone3;
	}

	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}
