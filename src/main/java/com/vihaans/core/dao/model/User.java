package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mt_users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "user_id")
	private String userId;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(name = "user_pwd")
	private String password;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "user_fname")
	private String firstName;

	@Size(min = 0, max = 50)
	@Column(name = "user_mname")
	private String middleName;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "user_lname")
	private String lastName;

	@Column(name = "active")
	private boolean active;
	
	@Size(min = 0, max = 100)
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_role")
	private Long userRole;
	
	@OneToOne
	@JoinColumn(name = "user_role", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private CustomRole customRole;
	
	@Transient
	private String fullName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		
		String fullName  = (firstName != null ? firstName + " " : "");
		fullName += (middleName != null ? middleName + " " : "");
		fullName += (lastName != null ? lastName + " " : "");
		return fullName.trim();
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getUserRole() {
		return userRole;
	}

	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}
	
	public CustomRole getCustomRole() {
		return customRole;
	}

	public void setCustomRole(CustomRole customRole) {
		this.customRole = customRole;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: " + id + "; ");
		sb.append("userId: " + userId + "; ");
		sb.append("password: " + password + "; ");
		sb.append("firstName: " + firstName + "; ");
		sb.append("middleName: " + middleName + "; ");
		sb.append("lastName: " + lastName + "; ");
		sb.append("active: " + active + "; ");
		sb.append("email: " + email + "; ");
		
		return sb.toString();
	}

}