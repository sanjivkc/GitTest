package com.vihaans.core.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mt_filing_tax_year")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FilingTaxYear extends BaseModelObject  
{	
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;
	
		@Size(min = 0, max = 255)
		@Column(name = "tax_year")
		private String taxYear;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTaxYear() {
			return taxYear;
		}

		public void setTaxYear(String taxYear) {
			this.taxYear = taxYear;
		}

		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("id: " + id + "; ");
			sb.append("taxYear: " + taxYear + "; ");
			return sb.toString();
		}
		
}