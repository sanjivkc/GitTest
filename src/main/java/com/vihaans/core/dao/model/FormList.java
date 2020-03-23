
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
@Table(name = "mt_form_list")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormList  extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "form_name")
	private String formName;
	
	
	@Size(min = 1, max = 255)
	@Column(name = "form_type")
	private String formType;
	
	@Size(min = 1, max = 255)
	@Column(name = "form_desc")
	private String formDesc;
	
	@Size(min = 1, max = 100)
	@Column(name = "submission_authority")
	private String submissionAuthority;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getSubmissionAuthority() {
		return submissionAuthority;
	}

	public void setSubmissionAuthority(String submissionAuthority) {
		this.submissionAuthority = submissionAuthority;
	}
	
	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + id + "; ");
		sb.append("formName:" + formName + "; ");
		sb.append("formType:" + formType + "; ");
		sb.append("formDesc:" + formDesc + "; ");
		sb.append("submissionAuthority:" + submissionAuthority + "; ");	
		return sb.toString();
	}
    

}



