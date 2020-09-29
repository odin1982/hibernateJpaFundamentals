package org.hibernate.data.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOND")
public class Bond extends Investment{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOND_ID")
	private Long bondId;
	
	@Column(name="VALUE")
	private BigDecimal value;
	
	@Column(name="INTEREST_RATE")
	private BigDecimal interestRate;
	
	@Column(name="MATURITY_DATE")
	private LocalDateTime maturityDate;
	
	@Column(name="PORTFOLIO_ID")
	private Long portfolioId;

	public Long getBondId() {
		return bondId;
	}

	public void setBondId(Long bondId) {
		this.bondId = bondId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDateTime getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDateTime maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}
	
}
