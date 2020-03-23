package com.vihaans.core.dao.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name = "mt_audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Size(min = 3, max = 80)
	@Column(name = "audit_type")
	private String auditType;

	@Size(max = 1000)
	@Column(name = "audit_data")
	private String auditData;

	@Size(min = 3, max = 50)
	@Column(name = "company_code")
	private String companyCode;

	@Size(min = 3, max = 100)
	@Column(name = "entity_type")
	private String entityType;

	@NotNull
	@Size(min = 3, max = 80)
	@Column(name = "audit_user")
	private String auditUser;
	
	@NotNull
	private Timestamp auditDate;

	public Audit(String auditType, Timestamp auditDate, String auditData,
			String companyCode, String entityType) {
		this.auditType = auditType;
		this.auditDate = auditDate;
		this.auditData = auditData;
		this.entityType = entityType;
		
		if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() !=null){
			try{
			UserDetail principal = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			this.companyCode = principal.getCompanyCode();
			this.auditUser = StringUtils.defaultIfBlank(SecurityContextHolder.getContext().getAuthentication().getName(), "System");
			}catch(Exception e){
				this.companyCode = "MITS";
				this.auditUser = "System";
			}
		}else{
			this.companyCode = "MITS";
			this.auditUser = "System";
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditData() {
		return auditData;
	}

	public void setAuditData(String auditData) {
		this.auditData = auditData;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("auditType:" + auditType + "; ");
		sb.append("auditDate:" + auditDate + "; ");

		return sb.toString();
	}
}
