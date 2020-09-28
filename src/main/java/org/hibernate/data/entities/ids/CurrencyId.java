package org.hibernate.data.entities.ids;

import java.io.Serializable;

public class CurrencyId implements Serializable{
	

	private static final long serialVersionUID = -7357289358959395568L;
	
	private String name;
	private String countryName;
	
	public CurrencyId() {
	}

	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
