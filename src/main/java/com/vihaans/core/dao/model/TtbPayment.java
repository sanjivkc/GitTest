
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
@Table(name = "mt_ttb_payment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TtbPayment extends BaseModelObject{
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private long id;
		
	    @NotNull
		@Size(min = 0, max = 5)
		@Column(name = "pay_mode")
		private String  payMode;
		
		@Size(min = 0, max = 1)
		@Column(name = "account_type")
		private String  accountType;
		
		@Size(min = 0, max = 20)
		@Column(name = "account_no")
		private  String accountNo;
		
		@Size(min = 0, max = 10)
		@Column(name = "routing_no")
		private  String routingNo;
		
		@Size(min = 0, max = 25)
		@Column(name = "payment_date")
		private  String paymentDate;
		
		@Size(min = 0, max = 10)
		@Column(name = "taxpayer_phone")
		private  String taxpayerPhone;
		
		@Size(min = 0, max = 1)
		@Column(name = "consent_eft")
		private String  consentEFT;
		
		@Size(min = 0, max = 1)
		@Column(name = "consent_check")
		private String  consentCheck;
		
		@Size(min = 0, max = 1)
		@Column(name = "consent_MO")
		private String  consentMo;
		
		@Size(min = 0, max = 255)
		@Column(name = "other")
		private String  other;
		
        @Column(name = "batch_id")
	    private String batchId;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPayMode() {
			return payMode;
		}

		public void setPayMode(String payMode) {
			this.payMode = payMode;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public String getRoutingNo() {
			return routingNo;
		}

		public void setRoutingNo(String routingNo) {
			this.routingNo = routingNo;
		}

		public String getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}

		public String getTaxpayerPhone() {
			return taxpayerPhone;
		}

		public void setTaxpayerPhone(String taxpayerPhone) {
			this.taxpayerPhone = taxpayerPhone;
		}

		public String getConsentEFT() {
			return consentEFT;
		}

		public void setConsentEFT(String consentEFT) {
			this.consentEFT = consentEFT;
		}

		public String getConsentCheck() {
			return consentCheck;
		}

		public void setConsentCheck(String consentCheck) {
			this.consentCheck = consentCheck;
		}

		public String getConsentMo() {
			return consentMo;
		}

		public void setConsentMo(String consentMo) {
			this.consentMo = consentMo;
		}

		public String getBatchId() {
			return batchId;
		}

		public void setBatchId(String batchId) {
			this.batchId = batchId;
		}

		public String getOther() {
			return other;
		}

		public void setOther(String other) {
			this.other = other;
		}

		@Override
		public String toString() {
			return "TtbPayment [id=" + id + ", payMode=" + payMode + ", accountType=" + accountType + ", accountNo="
					+ accountNo + ", routingNo=" + routingNo + ", paymentDate=" + paymentDate + ", taxpayerPhone="
					+ taxpayerPhone + ", consentEFT=" + consentEFT + ", consentCheck=" + consentCheck + ", consentMo="
					+ consentMo + ", other=" + other + ", batchId=" + batchId + "]";
		}

		

		

	      
}
