package com.pedrosantos.application.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedrosantos.application.domain.enums.PaymentStage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	private Integer stage;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "purchase_id")
	@MapsId
	private Purchase purchase;

	public Payment(Integer id, PaymentStage stage, Purchase purchase) {
		super();
		this.id = id;
		this.stage = (stage == null) ? null : stage.getCod();
		this.purchase = purchase;
	}

	public PaymentStage getStage() {
		return PaymentStage.toEnum(stage);
	}

	public void setStage(PaymentStage stage) {
		this.stage = stage.getCod();
	}
}
