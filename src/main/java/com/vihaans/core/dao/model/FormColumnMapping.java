
package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_form_column_mapping")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormColumnMapping  extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "form_id")
	private Long formId;
	
	@Column(name = "section_no")
	private Long sectionNo;
	
	@Column(name = "section_name")
	private String sectionName;
	
	@Column(name = "column_name")
	private String columnName;
	
	@Column(name = "flex_column_name")
	private String flexColumnName;
	
	@Column(name = "box_name")
	private String boxName;
	
	@Column(name = "tax_year")
	private String taxYear;
	
	@Column(name = "col_order")
	private Long colOrder;
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Long getFormId() {
		return formId;
	}




	public void setFormId(Long formId) {
		this.formId = formId;
	}




	public Long getSectionNo() {
		return sectionNo;
	}




	public void setSectionNo(Long sectionNo) {
		this.sectionNo = sectionNo;
	}




	public String getSectionName() {
		return sectionName;
	}




	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}




	public String getColumnName() {
		return columnName;
	}




	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}




	public String getFlexColumnName() {
		return flexColumnName;
	}




	public void setFlexColumnName(String flexColumnName) {
		this.flexColumnName = flexColumnName;
	}




	public String getBoxName() {
		return boxName;
	}




	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}




	public String getTaxYear() {
		return taxYear;
	}




	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}




	public Long getColOrder() {
		return colOrder;
	}




	public void setColOrder(Long colOrder) {
		this.colOrder = colOrder;
	}




	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + id + "; ");
		//sb.append("formName:" + formName + "; ");
		//sb.append("formType:" + formType + "; ");
		//sb.append("formDesc:" + formDesc + "; ");
		//sb.append("submissionAuthority:" + submissionAuthority + "; ");	
		return sb.toString();
	}
    

}



