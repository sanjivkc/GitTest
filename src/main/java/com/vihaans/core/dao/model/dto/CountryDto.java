package com.vihaans.core.dao.model.dto;

public class CountryDto {

	private Long id;
	private String countryCode;
	private String name;	
	private String groupId;	
	private String currency;
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
		return "CountryDto [id=" + id + ", countryCode=" + countryCode + ", name=" + name + ", groupId=" + groupId
				+ ", currency=" + currency + ", currSymbol=" + currSymbol + "]";
	}
	
	
}