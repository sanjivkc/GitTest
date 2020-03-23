package com.vihaans.core.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mt_transmission_header")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TransmissionHeader extends BaseModelObject{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "reference_no")
	private String referenceNo;
		
	@Column(name = "form_detail_id")
	private Long formDetailId;
	
	@Column(name = "industry_address_id")
	private Long industryAddressId;
	
	@Column(name = "industry_member_id")
	private Long industryMemberId;
	
	@Column(name = "submitted_date")
	private Date submittedDate;
	
	@Column(name = "status")
	@Size(min = 0, max = 100)
	private String status;
	
	@OneToOne
	@JoinColumn(name = "form_detail_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private FormDetails FormDetails;
	
	public FormDetails getFormDetails() {
		return FormDetails;
	}

	public void setFormDetails(FormDetails formDetails) {
		FormDetails = formDetails;
	}
	
	@OneToOne
	@JoinColumn(name = "industry_address_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private IndustryAddress IndustryAddress;
	
	
	
	public IndustryAddress getIndustryAddress() {
		return IndustryAddress;
	}

	public void setIndustryAddress(IndustryAddress industryAddress) {
		IndustryAddress = industryAddress;
	}

	@OneToOne
	@JoinColumn(name = "industry_member_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private IndustryMember IndustryMember;
	
	public IndustryMember getIndustryMember() {
		return IndustryMember;
	}

	public void setIndustryMember(IndustryMember industryMember) {
		IndustryMember = industryMember;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Long getFormDetailId() {
		return formDetailId;
	}

	public void setFormDetailId(Long formDetailId) {
		this.formDetailId = formDetailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getIndustryAddressId() {
		return industryAddressId;
	}

	public void setIndustryAddressId(Long industryAddressId) {
		this.industryAddressId = industryAddressId;
	}

	public Long getIndustryMemberId() {
		return industryMemberId;
	}

	public void setIndustryMemberId(Long industryMemberId) {
		this.industryMemberId = industryMemberId;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	

	@Override
	public String toString() {
		return "TransmissionHeader [id=" + id + ", referenceNo=" + referenceNo + ", formDetailId=" + formDetailId
				+ ", industryAddressId=" + industryAddressId + ", industryMemberId=" + industryMemberId
				+ ", submittedDate=" + submittedDate + ", status=" + status + ", FormDetails=" + FormDetails
				+ ", IndustryAddress=" + IndustryAddress + ", IndustryMember=" + IndustryMember + "]";
	}

	

	
	
}
