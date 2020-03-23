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
@Table(name = "mt_industry")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IndustryMember  extends BaseModelObject 
{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@NotNull
	@Column(name = "user_id")
	private Long userId;
	
	@Size(min = 0, max = 255)
	@Column(name = "industry_name")
	private String industryName;
	
	@Size(min = 0, max = 1)
	@Column(name = "ein_type")
	private String einType ;
	
	@Size(min = 0, max = 50)
	@Column(name = "ein_no")
	private String einNo ;
	
	@Column(name = "dba_name")
	private String dbaName;
	
	@Column(name = "dot_no")
	private String dotNo;
	
	@Size(min = 0, max = 255)
	@Column(name = "address1")
	private String address1;
	
	@Size(min = 0, max = 255)
	@Column(name = "address2")
	private String address2;
	
	@Size(min = 0, max = 255)
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private Long state;
	
	@Column(name = "state_code")
	private String stateCode;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "country_id")
	private Long countryId;
	
	@Size(min = 0, max = 10)
	@Column(name = "zip_code")
	private String zipCode;
	
	@Size(min = 0, max = 255)
	@Column(name = "email")
	private String email;
	
	@Size(min = 0, max = 255)
	@Column(name = "fax_no")
	private String faxNo;
	
	@Size(min = 0, max = 15)
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "batch_id")
    private String batchId;
	
	@Size(min = 0, max = 255)
	@Column(name = "permit_no")
	private String permitNo;
	
	@Size(min = 0, max = 1)
	@Column(name = "status")
	private String status ;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getEinType() {
		return einType;
	}

	public void setEinType(String einType) {
		this.einType = einType;
	}

	public String getEinNo() {
		return einNo;
	}

	public void setEinNo(String einNo) {
		this.einNo = einNo;
	}

	public String getDbaName() {
		return dbaName;
	}

	public void setDbaName(String dbaName) {
		this.dbaName = dbaName;
	}

	public String getDotNo() {
		return dotNo;
	}

	public void setDotNo(String dotNo) {
		this.dotNo = dotNo;
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

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getPermitNo() {
		return permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString()
	{
		
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("userId: " + userId + "; ");
		sb.append("industryName: " + industryName + "; ");
		sb.append("einType: " + einType + "; ");
		sb.append("einNo: " + einNo + "; ");
		sb.append("dbaName: " + dbaName + "; ");
		sb.append("dotNo: " + dotNo + "; ");
		sb.append("address1: " + address1 + "; ");
		sb.append("address2: " + address2 + "; ");
		sb.append("city: " + city + "; ");
		sb.append("state: " + state + "; ");
		sb.append("stateCode: " + stateCode + "; ");
		sb.append("zipCode: " + zipCode + "; ");
		sb.append("email: " + email + "; ");
		sb.append("faxNo: " + faxNo + "; ");
		sb.append("phoneNumber: " + phoneNumber + "; ");
		sb.append("countryCode: " + countryCode + "; ");
		sb.append("countryId: " + countryId + "; ");
		sb.append("batchId: " + batchId + "; ");
		sb.append("permitNo: " + permitNo + "; ");
		sb.append("status: " + status + "; ");
		return sb.toString();
		
	}

}