package org.hibernate.data.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Investment {

	@Column(name = "NAME")
	protected String name;
	
	@Column(name = "ISSUER")
	protected String issuer;
	
	@Column(name = "PURCHASE_DATE")
	protected LocalDateTime purchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	

}