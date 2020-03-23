package com.vihaans.core.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public abstract class BaseModelObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_by")
	protected String createdBy;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Column(name = "last_modified_by")
	protected String modifiedBy;

	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;

	@Column(name = "company_code")
	protected String companyCode;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@PreUpdate
	public void updateMetadata() {
		modifiedDate = new Date();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null){
			modifiedBy = "Scheduler";
		}else{
			modifiedBy = StringUtils.defaultIfBlank(SecurityContextHolder.getContext().getAuthentication().getName(), "System");
		}
	}

	@PrePersist
	public void createMetadata() {
		
		String aModifiedBy = "";
		String aCreatedBy  = "";
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null){
			aModifiedBy = "Scheduler";
			aCreatedBy  = "Scheduler";
		}else{
			aCreatedBy = StringUtils.defaultIfBlank(SecurityContextHolder.getContext().getAuthentication().getName(), "System");
			aModifiedBy = aCreatedBy;
		}
		
		createdBy = aCreatedBy;
		createdDate = new Date();
		modifiedBy = aModifiedBy;
		modifiedDate = new Date();
		if(companyCode == "" || companyCode == null)
		{
			if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null){
				try{
					
						UserDetail principal = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
						companyCode = principal.getCompanyCode();
					
				}catch(Exception e){
					this.companyCode = "MITS";
					//this.auditUser = "System";
				}
			}else{
				companyCode = "MITS";
			}
		}
	}
}