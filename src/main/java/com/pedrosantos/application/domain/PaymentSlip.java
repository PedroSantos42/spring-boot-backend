package com.pedrosantos.application.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedrosantos.application.domain.enums.PaymentStage;

@Entity
public class PaymentSlip extends Payment {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date expiration;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date payDay;
	
	public PaymentSlip() {}
	
	public PaymentSlip(Integer id, PaymentStage stage, Purchase order, Date expiration, Date payDay) {
		super(id, stage, order);
		this.expiration = expiration;
		this.payDay = payDay;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
}
