package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mt_role_access")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoleAccess extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "role_id")
	private Long roleId;
	
	
	@Column(name = "option_id")
	private Long optionId;
	
	@OneToOne
	@JoinColumn(name = "option_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private Option option;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
     
     public Long getRoleId() {
 		return roleId;
 	}

 	public void setRoleId(Long roleId) {
 		this.roleId = roleId;
 	}
 	
 	public Option getOption() {
 		return option;
 	}

 	public void setOption(Option option) {
 		this.option = option;
 	}
 	
 	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId =optionId;
	}
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("roleId: " + roleId + "; ");
		sb.append("optionId: " + optionId + "; ");
		
		return sb.toString();
	}

	

	

}
