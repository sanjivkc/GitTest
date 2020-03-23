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
@Table(name = "mt_state")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class State extends BaseModelObject  {	
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;

		@NotNull
		@Size(min = 0, max = 10)
		@Column(name = "state_code")
		private String stateCode;
		
		@Size(min = 0, max = 50)
		@Column(name = "name")
		private String name;	
		
		@Size(min = 0, max = 10)
		@Column(name = "country_code")
		private String countryCode;		
		
		@Size(min = 0, max = 10)
		@Column(name = "state_id")
		private String stateId;
		
		@Size(min = 0, max = 10)
		@Column(name = "combined_federal_state_code")
		private String combinedFederalStateCode;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStateCode() {
			return stateCode;
		}

		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
				
		public String getStateId() {
			return stateId;
		}

		public void setStateId(String stateId) {
			this.stateId = stateId;
		}

		public String getCombinedFederalStateCode() {
			return combinedFederalStateCode;
		}

		public void setCombinedFederalStateCode(String combinedFederalStateCode) {
			this.combinedFederalStateCode = combinedFederalStateCode;
		}

		@Override
		public String toString() {
			return "State [id=" + id + ", stateCode=" + stateCode + ", name=" + name + ", countryCode=" + countryCode + "]";
		}
		
	}