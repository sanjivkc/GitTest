package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_country")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Country extends BaseModelObject{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 0, max = 10)
	@Column(name = "country_code")
	private String countryCode;
	
	@Size(min = 0, max = 100)
	@Column(name = "name")
	private String name;	
	
	@Size(min = 0, max = 45)
	@Column(name = "group_id")
	private String groupId;	
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "currency_symbol")
	private String currSymbol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrSymbol() {
		return currSymbol;
	}

	public void setCurrSymbol(String currSymbol) {
		this.currSymbol = currSymbol;
	}

	@Override
	public String toString() {
		return "CountryState [id=" + id + ", countryCode=" + countryCode + ", name=" + name + ", groupId=" + groupId
				+ ", currency=" + currency + ", currSymbol=" + currSymbol + "]";
	}

	
}