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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_custom_roles")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CustomRole extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "name")
	private String name;

	@Size(min = 0, max = 250)
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "role_group_id")
	private long roleGroupId;


	
	@Size(min = 0, max = 1)
	@Column(name = "status")
	private String active;
	
	@OneToOne
	@JoinColumn(name = "role_group_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonBackReference
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long  getId() {
		return id;
	}

	public void setId(long  id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long  getRoleGroupId() {
		return roleGroupId;
	}

	public void setRoleGroupId(long  roleGroupId) {
		this.roleGroupId = roleGroupId;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("name: " + name + "; ");
		sb.append("description: " + description + "; ");
		sb.append("roleGroupId: " + roleGroupId + "; ");
		sb.append("status: " + active + "; ");
		return sb.toString();
	}

}
