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
@Table(name = "mt_industry_address")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IndustryAddress  extends BaseModelObject 
{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@NotNull
	@Column(name = "industry_id")
	private Long industryId;
	
	@Size(min = 0, max = 255)
	@Column(name = "permit_no")
	private String permitNo;
	
	@Size(min = 0, max = 255)
	@Column(name = "registry_no")
	private String registryNo;
	
	@Size(min = 0, max = 255)
	@Column(name = "address1")
	private String address1;
	
	@Size(min = 0, max = 255)
	@Column(name = "address2")
	private String address2;
	
	@Size(min = 0, max = 255)
	@Column(name = "city")
	private String city;
	
	@Column(name = "state_code")
	private String stateCode;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Size(min = 0, max = 10)
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "batch_id")
    private String batchId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	public String getPermitNo() {
		return permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	public String getRegistryNo() {
		return registryNo;
	}

	public void setRegistryNo(String registryNo) {
		this.registryNo = registryNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("industryId: " + industryId + "; ");
		sb.append("permitNo: " + permitNo + "; ");
		sb.append("registryNo: " + registryNo + "; ");
		sb.append("address1: " + address1 + "; ");
		sb.append("address2: " + address2 + "; ");
		sb.append("city: " + city + "; ");
		sb.append("stateCode: " + stateCode + "; ");
		sb.append("countryCode: " + countryCode + "; ");
		sb.append("zipCode: " + zipCode + "; ");
		sb.append("batchId: " + batchId + "; ");
		return sb.toString();
	}

}