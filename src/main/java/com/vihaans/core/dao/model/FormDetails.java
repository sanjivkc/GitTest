package com.vihaans.core.dao.model;

import java.util.Date;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mt_form_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class FormDetails  extends BaseModelObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "form_id")
	private Long formId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "payment_id")
	private Long paymentId;
	
	@Column(name = "industry_member_id")
	private Long industryMemberId;
	
	@Column(name = "industry_address_id")
	private Long industryAddressId;
	
	@Column(name = "preview_pdf")
    private String previewPdf;
	
	@Column(name = "submitted_pdf")
    private String submittedPdf;
	
	@Column(name = "xml_file")
    private String xmlFile;
	
	@Column(name = "error_msg")
    private String errorMsg;
	
	@Column(name = "current_position")
	private Long currentPosition;
	
	@Column(name = "highest_position")
	private Long highestPosition;
	
	@Column(name = "attribute1")
    private String attribute1;

	@Column(name = "attribute2")
    private String attribute2;
    
	@Column(name = "attribute3")
    private String attribute3;
    
	@Column(name = "attribute4")
    private String attribute4;
    
	@Column(name = "attribute5")
    private String attribute5;
    
	@Column(name = "attribute6")
    private String attribute6;
    
	@Column(name = "attribute7")
    private String attribute7;
    
	@Column(name = "attribute8")
    private String attribute8;
    
	@Column(name = "attribute9")
    private String attribute9;
    
	@Column(name = "attribute10")
    private String attribute10;
	
	@Column(name = "attribute11")
    private String attribute11;
    
	@Column(name = "attribute12")
    private String attribute12;
    
	@Column(name = "attribute13")
    private String attribute13;
    
	@Column(name = "attribute14")
    private String attribute14;
    
	@Column(name = "attribute15")
    private String attribute15;
    
	@Column(name = "attribute16")
    private String attribute16;
    
	@Column(name = "attribute17")
    private String attribute17;
    
	@Column(name = "attribute18")
    private String attribute18;
    
	@Column(name = "attribute19")
    private String attribute19;
    
	@Column(name = "attribute20")
    private String attribute20;
    
	@Column(name = "attribute21")
    private String attribute21;
    
	@Column(name = "attribute22")
    private String attribute22;
    
	@Column(name = "attribute23")
    private String attribute23;
    
	@Column(name = "attribute24")
    private String attribute24;
	
	@Column(name = "attribute25")
    private String attribute25;
	
	@Column(name = "attribute26")
    private String attribute26;
	
	@Column(name = "attribute27")
    private String attribute27;
	
	@Column(name = "attribute28")
    private String attribute28;
	
	@Column(name = "attribute29")
    private String attribute29;
	
	@Column(name = "attribute30")
    private String attribute30;
	
	@Column(name = "attribute31")
    private String attribute31;
	
	@Column(name = "attribute32")
    private String attribute32;
	
	@Column(name = "attribute33")
    private String attribute33;
	
	@Column(name = "attribute34")
    private String attribute34;
	
	@Column(name = "attribute35")
    private String attribute35;
	
	@Column(name = "attribute36")
    private String attribute36;
	
	@Column(name = "attribute37")
    private String attribute37;
	
	@Column(name = "attribute38")
    private String attribute38;
	
	@Column(name = "attribute39")
    private String attribute39;
	
	@Column(name = "attribute40")
    private String attribute40;
	
	@Column(name = "attribute41")
    private String attribute41;
	
	@Column(name = "attribute42")
    private String attribute42;
	
	@Column(name = "attribute43")
    private String attribute43;
	
	@Column(name = "attribute44")
    private String attribute44;
	
	@Column(name = "attribute45")
    private String attribute45;
	
	@Column(name = "attribute46")
    private String attribute46;
	
	@Column(name = "attribute47")
    private String attribute47;
	
	@Column(name = "attribute48")
    private String attribute48;
	
	@Column(name = "attribute49")
    private String attribute49;
	
	@Column(name = "attribute50")
    private String attribute50;
	
	@Column(name = "attribute51")
    private Double attribute51;
	
	@Column(name = "attribute52")
    private Double attribute52;
	
	@Column(name = "attribute53")
    private Double attribute53;
	
	@Column(name = "attribute54")
    private Double attribute54;
	
	@Column(name = "attribute55")
    private Double attribute55;
	
	@Column(name = "attribute56")
    private Double attribute56;
	
	@Column(name = "attribute57")
    private Double attribute57;
	
	@Column(name = "attribute58")
    private Double attribute58;
	
	@Column(name = "attribute59")
    private Double attribute59;
	
	@Column(name = "attribute60")
    private Double attribute60;
    
	@Column(name = "attribute61")
    private Double attribute61;
    
	@Column(name = "attribute62")
    private Double attribute62;
	
	@Column(name = "attribute63")
    private Double attribute63;
	
	@Column(name = "attribute64")
    private Double attribute64;
	
	@Column(name = "attribute65")
    private Double attribute65;
	
	@Column(name = "attribute66")
    private Double attribute66;
    
	@Column(name = "attribute67")
    private Double attribute67;
    
	@Column(name = "attribute68")
    private Double attribute68;
	
	@Column(name = "attribute69")
    private Double attribute69;
	
	@Column(name = "attribute70")
    private Double attribute70;
	
	@Column(name = "attribute71")
    private Double attribute71;
	
	@Column(name = "attribute72")
    private Double attribute72;
	
	@Column(name = "attribute73")
    private Double attribute73;
	
	@Column(name = "attribute74")
    private Double attribute74;
	
	@Column(name = "attribute75")
    private Double attribute75;
	
	@Column(name = "attribute76")
    private Date attribute76;
	
	@Column(name = "attribute77")
    private Date attribute77;
	
	@Column(name = "attribute78")
    private Date attribute78;
	
	@Column(name = "attribute79")
    private Date attribute79;
	
	@Column(name = "attribute80")
    private Date attribute80;
	
	@Column(name = "attribute81")
    private Date attribute81;
	
	@Column(name = "attribute82")
    private Date attribute82;
	
	@Column(name = "attribute83")
    private Date attribute83;
	
	@Column(name = "attribute84")
    private Date attribute84;
	
	@Column(name = "attribute85")
    private Date attribute85;
	
	@Column(name = "attribute86")
    private Double attribute86;
	
	@Column(name = "attribute87")
    private Double attribute87;
	
	@Column(name = "attribute88")
    private Double attribute88;
	
	@Column(name = "attribute89")
    private Double attribute89;
	
	@Column(name = "attribute90")
    private Double attribute90;
	
	@Column(name = "attribute91")
    private Double attribute91;
	
	@Column(name = "attribute92")
    private Double attribute92;
	
	@Column(name = "attribute93")
    private Double attribute93;
	
	@Column(name = "attribute94")
    private Double attribute94;
	
	@Column(name = "attribute95")
    private Double attribute95;
	
	@Column(name = "attribute96")
    private Double attribute96;
	
	@Column(name = "attribute97")
    private Double attribute97;
	
	@Column(name = "attribute98")
    private Double attribute98;
	
	@Column(name = "attribute99")
    private Double attribute99;
	
	@Column(name = "attribute100")
    private Double attribute100;
	
	@Size(min = 0, max = 1)
	@Column(name = "status")
	private String status;
	
	@Column(name = "ref_no")
	private String refNo;
	
	@Column(name = "tax_year")
    private String taxYear;
	
	@Column(name = "file_freq")
    private String filingFreq;
	
	@Column(name = "service_type")
    private String serviceType;
	
	@Column(name = "form_price")
    private Double formPrice;

	@Column(name = "digital_signature")
	private String digitalSignature;
	
	@Column(name = "batch_id")
	private  String batchId;
	
	@Column(name = "slab_flag")
	private String slabFlag;
	
	@Column(name = "sign_name")
	private  String signName;
	
	@Column(name = "sign_phone")
	private String signPhone;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private User User;
	
	@OneToOne
	@JoinColumn(name = "industry_member_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private IndustryMember industryMember;
	
	@OneToOne
	@JoinColumn(name = "industry_address_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private IndustryAddress industryAddress;
	
	@OneToOne
	@JoinColumn(name = "payment_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private TtbPayment ttbPayment;
	
	@OneToOne
	@JoinColumn(name = "form_id", referencedColumnName="id", insertable = false, updatable = false )
	@JsonManagedReference
	private FormList formList;

	
	public FormList getFormList() {
		return formList;
	}

	public void setFormList(FormList formList) {
		this.formList = formList;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public TtbPayment getTtbPayment() {
		return ttbPayment;
	}

	public void setTtbPayment(TtbPayment ttbPayment) {
		this.ttbPayment = ttbPayment;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getIndustryMemberId() {
		return industryMemberId;
	}

	public void setIndustryMemberId(Long industryMemberId) {
		this.industryMemberId = industryMemberId;
	}

	public Long getIndustryAddressId() {
		return industryAddressId;
	}

	public void setIndustryAddressId(Long industryAddressId) {
		this.industryAddressId = industryAddressId;
	}

	public String getPreviewPdf() {
		return previewPdf;
	}

	public void setPreviewPdf(String previewPdf) {
		this.previewPdf = previewPdf;
	}

	public String getSubmittedPdf() {
		return submittedPdf;
	}

	public void setSubmittedPdf(String submittedPdf) {
		this.submittedPdf = submittedPdf;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Long currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Long getHighestPosition() {
		return highestPosition;
	}

	public void setHighestPosition(Long highestPosition) {
		this.highestPosition = highestPosition;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAttribute12() {
		return attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute13() {
		return attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute14() {
		return attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute15() {
		return attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

	public String getAttribute16() {
		return attribute16;
	}

	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}

	public String getAttribute17() {
		return attribute17;
	}

	public void setAttribute17(String attribute17) {
		this.attribute17 = attribute17;
	}

	public String getAttribute18() {
		return attribute18;
	}

	public void setAttribute18(String attribute18) {
		this.attribute18 = attribute18;
	}

	public String getAttribute19() {
		return attribute19;
	}

	public void setAttribute19(String attribute19) {
		this.attribute19 = attribute19;
	}

	public String getAttribute20() {
		return attribute20;
	}

	public void setAttribute20(String attribute20) {
		this.attribute20 = attribute20;
	}

	public String getAttribute21() {
		return attribute21;
	}

	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}

	public String getAttribute22() {
		return attribute22;
	}

	public void setAttribute22(String attribute22) {
		this.attribute22 = attribute22;
	}

	public String getAttribute23() {
		return attribute23;
	}

	public void setAttribute23(String attribute23) {
		this.attribute23 = attribute23;
	}

	public String getAttribute24() {
		return attribute24;
	}

	public void setAttribute24(String attribute24) {
		this.attribute24 = attribute24;
	}

	public String getAttribute25() {
		return attribute25;
	}

	public void setAttribute25(String attribute25) {
		this.attribute25 = attribute25;
	}

	public String getAttribute26() {
		return attribute26;
	}

	public void setAttribute26(String attribute26) {
		this.attribute26 = attribute26;
	}

	public String getAttribute27() {
		return attribute27;
	}

	public void setAttribute27(String attribute27) {
		this.attribute27 = attribute27;
	}

	public String getAttribute28() {
		return attribute28;
	}

	public void setAttribute28(String attribute28) {
		this.attribute28 = attribute28;
	}

	public String getAttribute29() {
		return attribute29;
	}

	public void setAttribute29(String attribute29) {
		this.attribute29 = attribute29;
	}

	public String getAttribute30() {
		return attribute30;
	}

	public void setAttribute30(String attribute30) {
		this.attribute30 = attribute30;
	}

	public String getAttribute31() {
		return attribute31;
	}

	public void setAttribute31(String attribute31) {
		this.attribute31 = attribute31;
	}

	public String getAttribute32() {
		return attribute32;
	}

	public void setAttribute32(String attribute32) {
		this.attribute32 = attribute32;
	}

	public String getAttribute33() {
		return attribute33;
	}

	public void setAttribute33(String attribute33) {
		this.attribute33 = attribute33;
	}

	public String getAttribute34() {
		return attribute34;
	}

	public void setAttribute34(String attribute34) {
		this.attribute34 = attribute34;
	}

	public String getAttribute35() {
		return attribute35;
	}

	public void setAttribute35(String attribute35) {
		this.attribute35 = attribute35;
	}

	public String getAttribute36() {
		return attribute36;
	}

	public void setAttribute36(String attribute36) {
		this.attribute36 = attribute36;
	}

	public String getAttribute37() {
		return attribute37;
	}

	public void setAttribute37(String attribute37) {
		this.attribute37 = attribute37;
	}

	public String getAttribute38() {
		return attribute38;
	}

	public void setAttribute38(String attribute38) {
		this.attribute38 = attribute38;
	}

	public String getAttribute39() {
		return attribute39;
	}

	public void setAttribute39(String attribute39) {
		this.attribute39 = attribute39;
	}

	public String getAttribute40() {
		return attribute40;
	}

	public void setAttribute40(String attribute40) {
		this.attribute40 = attribute40;
	}

	public String getAttribute41() {
		return attribute41;
	}

	public void setAttribute41(String attribute41) {
		this.attribute41 = attribute41;
	}

	public String getAttribute42() {
		return attribute42;
	}

	public void setAttribute42(String attribute42) {
		this.attribute42 = attribute42;
	}

	public String getAttribute43() {
		return attribute43;
	}

	public void setAttribute43(String attribute43) {
		this.attribute43 = attribute43;
	}

	public String getAttribute44() {
		return attribute44;
	}

	public void setAttribute44(String attribute44) {
		this.attribute44 = attribute44;
	}

	public String getAttribute45() {
		return attribute45;
	}

	public void setAttribute45(String attribute45) {
		this.attribute45 = attribute45;
	}

	public String getAttribute46() {
		return attribute46;
	}

	public void setAttribute46(String attribute46) {
		this.attribute46 = attribute46;
	}

	public String getAttribute47() {
		return attribute47;
	}

	public void setAttribute47(String attribute47) {
		this.attribute47 = attribute47;
	}

	public String getAttribute48() {
		return attribute48;
	}

	public void setAttribute48(String attribute48) {
		this.attribute48 = attribute48;
	}

	public String getAttribute49() {
		return attribute49;
	}

	public void setAttribute49(String attribute49) {
		this.attribute49 = attribute49;
	}

	public String getAttribute50() {
		return attribute50;
	}

	public void setAttribute50(String attribute50) {
		this.attribute50 = attribute50;
	}

	public Double getAttribute51() {
		return attribute51;
	}

	public void setAttribute51(Double attribute51) {
		this.attribute51 = attribute51;
	}

	public Double getAttribute52() {
		return attribute52;
	}

	public void setAttribute52(Double attribute52) {
		this.attribute52 = attribute52;
	}

	public Double getAttribute53() {
		return attribute53;
	}

	public void setAttribute53(Double attribute53) {
		this.attribute53 = attribute53;
	}

	public Double getAttribute54() {
		return attribute54;
	}

	public void setAttribute54(Double attribute54) {
		this.attribute54 = attribute54;
	}

	public Double getAttribute55() {
		return attribute55;
	}

	public void setAttribute55(Double attribute55) {
		this.attribute55 = attribute55;
	}

	public Double getAttribute56() {
		return attribute56;
	}

	public void setAttribute56(Double attribute56) {
		this.attribute56 = attribute56;
	}

	public Double getAttribute57() {
		return attribute57;
	}

	public void setAttribute57(Double attribute57) {
		this.attribute57 = attribute57;
	}

	public Double getAttribute58() {
		return attribute58;
	}

	public void setAttribute58(Double attribute58) {
		this.attribute58 = attribute58;
	}

	public Double getAttribute59() {
		return attribute59;
	}

	public void setAttribute59(Double attribute59) {
		this.attribute59 = attribute59;
	}

	public Double getAttribute60() {
		return attribute60;
	}

	public void setAttribute60(Double attribute60) {
		this.attribute60 = attribute60;
	}

	public Double getAttribute61() {
		return attribute61;
	}

	public void setAttribute61(Double attribute61) {
		this.attribute61 = attribute61;
	}

	public Double getAttribute62() {
		return attribute62;
	}

	public void setAttribute62(Double attribute62) {
		this.attribute62 = attribute62;
	}

	public Double getAttribute63() {
		return attribute63;
	}

	public void setAttribute63(Double attribute63) {
		this.attribute63 = attribute63;
	}

	public Double getAttribute64() {
		return attribute64;
	}

	public void setAttribute64(Double attribute64) {
		this.attribute64 = attribute64;
	}

	public Double getAttribute65() {
		return attribute65;
	}

	public void setAttribute65(Double attribute65) {
		this.attribute65 = attribute65;
	}

	public Double getAttribute66() {
		return attribute66;
	}

	public void setAttribute66(Double attribute66) {
		this.attribute66 = attribute66;
	}

	public Double getAttribute67() {
		return attribute67;
	}

	public void setAttribute67(Double attribute67) {
		this.attribute67 = attribute67;
	}

	public Double getAttribute68() {
		return attribute68;
	}

	public void setAttribute68(Double attribute68) {
		this.attribute68 = attribute68;
	}

	public Double getAttribute69() {
		return attribute69;
	}

	public void setAttribute69(Double attribute69) {
		this.attribute69 = attribute69;
	}

	public Double getAttribute70() {
		return attribute70;
	}

	public void setAttribute70(Double attribute70) {
		this.attribute70 = attribute70;
	}

	public Double getAttribute71() {
		return attribute71;
	}

	public void setAttribute71(Double attribute71) {
		this.attribute71 = attribute71;
	}

	public Double getAttribute72() {
		return attribute72;
	}

	public void setAttribute72(Double attribute72) {
		this.attribute72 = attribute72;
	}

	public Double getAttribute73() {
		return attribute73;
	}

	public void setAttribute73(Double attribute73) {
		this.attribute73 = attribute73;
	}

	public Double getAttribute74() {
		return attribute74;
	}

	public void setAttribute74(Double attribute74) {
		this.attribute74 = attribute74;
	}

	public Double getAttribute75() {
		return attribute75;
	}

	public void setAttribute75(Double attribute75) {
		this.attribute75 = attribute75;
	}

	public Date getAttribute76() {
		return attribute76;
	}

	public void setAttribute76(Date attribute76) {
		this.attribute76 = attribute76;
	}

	public Date getAttribute77() {
		return attribute77;
	}

	public void setAttribute77(Date attribute77) {
		this.attribute77 = attribute77;
	}

	public Date getAttribute78() {
		return attribute78;
	}

	public void setAttribute78(Date attribute78) {
		this.attribute78 = attribute78;
	}

	public Date getAttribute79() {
		return attribute79;
	}

	public void setAttribute79(Date attribute79) {
		this.attribute79 = attribute79;
	}

	public Date getAttribute80() {
		return attribute80;
	}

	public void setAttribute80(Date attribute80) {
		this.attribute80 = attribute80;
	}

	public Date getAttribute81() {
		return attribute81;
	}

	public void setAttribute81(Date attribute81) {
		this.attribute81 = attribute81;
	}

	public Date getAttribute82() {
		return attribute82;
	}

	public void setAttribute82(Date attribute82) {
		this.attribute82 = attribute82;
	}

	public Date getAttribute83() {
		return attribute83;
	}

	public void setAttribute83(Date attribute83) {
		this.attribute83 = attribute83;
	}

	public Date getAttribute84() {
		return attribute84;
	}

	public void setAttribute84(Date attribute84) {
		this.attribute84 = attribute84;
	}

	public Date getAttribute85() {
		return attribute85;
	}

	public void setAttribute85(Date attribute85) {
		this.attribute85 = attribute85;
	}

	public Double getAttribute86() {
		return attribute86;
	}

	public void setAttribute86(Double attribute86) {
		this.attribute86 = attribute86;
	}

	public Double getAttribute87() {
		return attribute87;
	}

	public void setAttribute87(Double attribute87) {
		this.attribute87 = attribute87;
	}

	public Double getAttribute88() {
		return attribute88;
	}

	public void setAttribute88(Double attribute88) {
		this.attribute88 = attribute88;
	}

	public Double getAttribute89() {
		return attribute89;
	}

	public void setAttribute89(Double attribute89) {
		this.attribute89 = attribute89;
	}

	public Double getAttribute90() {
		return attribute90;
	}

	public void setAttribute90(Double attribute90) {
		this.attribute90 = attribute90;
	}

	public Double getAttribute91() {
		return attribute91;
	}

	public void setAttribute91(Double attribute91) {
		this.attribute91 = attribute91;
	}

	public Double getAttribute92() {
		return attribute92;
	}

	public void setAttribute92(Double attribute92) {
		this.attribute92 = attribute92;
	}

	public Double getAttribute93() {
		return attribute93;
	}

	public void setAttribute93(Double attribute93) {
		this.attribute93 = attribute93;
	}

	public Double getAttribute94() {
		return attribute94;
	}

	public void setAttribute94(Double attribute94) {
		this.attribute94 = attribute94;
	}

	public Double getAttribute95() {
		return attribute95;
	}

	public void setAttribute95(Double attribute95) {
		this.attribute95 = attribute95;
	}

	public Double getAttribute96() {
		return attribute96;
	}

	public void setAttribute96(Double attribute96) {
		this.attribute96 = attribute96;
	}

	public Double getAttribute97() {
		return attribute97;
	}

	public void setAttribute97(Double attribute97) {
		this.attribute97 = attribute97;
	}

	public Double getAttribute98() {
		return attribute98;
	}

	public void setAttribute98(Double attribute98) {
		this.attribute98 = attribute98;
	}

	public Double getAttribute99() {
		return attribute99;
	}

	public void setAttribute99(Double attribute99) {
		this.attribute99 = attribute99;
	}

	public Double getAttribute100() {
		return attribute100;
	}

	public void setAttribute100(Double attribute100) {
		this.attribute100 = attribute100;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public String getFilingFreq() {
		return filingFreq;
	}

	public void setFilingFreq(String filingFreq) {
		this.filingFreq = filingFreq;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Double getFormPrice() {
		return formPrice;
	}

	public void setFormPrice(Double formPrice) {
		this.formPrice = formPrice;
	}

	public String getDigitalSignature() {
		return digitalSignature;
	}

	public void setDigitalSignature(String digitalSignature) {
		this.digitalSignature = digitalSignature;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getSlabFlag() {
		return slabFlag;
	}

	public void setSlabFlag(String slabFlag) {
		this.slabFlag = slabFlag;
	}
	
	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignPhone() {
		return signPhone;
	}

	public void setSignPhone(String signPhone) {
		this.signPhone = signPhone;
	}
	
	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public IndustryMember getIndustryMember() {
		return industryMember;
	}

	public void setIndustryMember(IndustryMember industryMember) {
		this.industryMember = industryMember;
	}

	public IndustryAddress getIndustryAddress() {
		return industryAddress;
	}

	public void setIndustryAddress(IndustryAddress industryAddress) {
		this.industryAddress = industryAddress;
	}
	
	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public void setField(String aFieldName, Object aValue) 
	{
		 try
		 {
			 Field aField = getClass().getDeclaredField(aFieldName);
			 if(!aField.getType().isInstance(aValue))
			 {
				 if(aField.getType().equals(Double.class))
				 { 
					 aValue= aValue != null ? aValue : "";
					 if(!aValue.equals(""))
					 {
						 DecimalFormat df = new DecimalFormat("#.##");
						 Double aValueTemp = Double.valueOf(df.format(Double.parseDouble(aValue.toString())));
						 Double convertedVal = Double.parseDouble(aValueTemp.toString());
						 aField.set(this, convertedVal); 
					 }
					 else 
					 { 
						 aField.set(this, null);  
					 }
				 }
				 
				if(aField.getType().equals(Date.class))
				 {
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date convertedDate = formatter.parse(aValue.toString());
					aField.set(this, convertedDate);
				 }
			 }
			 else
			 {
				 aField.set(this, aValue);
			 }
		 }
		 catch(Exception ex)
		 { 
		 }
	}
	
	public Object getField(String aFieldName) 
	{
		 try
		 {
			 Field aField = getClass().getDeclaredField(aFieldName);
			 return aField.get(this);
		 }
		 catch(Exception ex)
		 {
			 return null;
		 }
	}

	@Override
	public String toString() {
		return "FormDetails [id=" + id + ", formId=" + formId + ", userId=" + userId + ", industryMemberId="
				+ industryMemberId + ", industryAddressId=" + industryAddressId + ", previewPdf=" + previewPdf
				+ ", submittedPdf=" + submittedPdf + ", errorMsg=" + errorMsg + ", currentPosition=" + currentPosition
				+ ", highestPosition=" + highestPosition + ", attribute1=" + attribute1 + ", attribute2=" + attribute2
				+ ", attribute3=" + attribute3 + ", attribute4=" + attribute4 + ", attribute5=" + attribute5
				+ ", attribute6=" + attribute6 + ", attribute7=" + attribute7 + ", attribute8=" + attribute8
				+ ", attribute9=" + attribute9 + ", attribute10=" + attribute10 + ", attribute11=" + attribute11
				+ ", attribute12=" + attribute12 + ", attribute13=" + attribute13 + ", attribute14=" + attribute14
				+ ", attribute15=" + attribute15 + ", attribute16=" + attribute16 + ", attribute17=" + attribute17
				+ ", attribute18=" + attribute18 + ", attribute19=" + attribute19 + ", attribute20=" + attribute20
				+ ", attribute21=" + attribute21 + ", attribute22=" + attribute22 + ", attribute23=" + attribute23
				+ ", attribute24=" + attribute24 + ", attribute25=" + attribute25 + ", attribute26=" + attribute26
				+ ", attribute27=" + attribute27 + ", attribute28=" + attribute28 + ", attribute29=" + attribute29
				+ ", attribute30=" + attribute30 + ", attribute31=" + attribute31 + ", attribute32=" + attribute32
				+ ", attribute33=" + attribute33 + ", attribute34=" + attribute34 + ", attribute35=" + attribute35
				+ ", attribute36=" + attribute36 + ", attribute37=" + attribute37 + ", attribute38=" + attribute38
				+ ", attribute39=" + attribute39 + ", attribute40=" + attribute40 + ", attribute41=" + attribute41
				+ ", attribute42=" + attribute42 + ", attribute43=" + attribute43 + ", attribute44=" + attribute44
				+ ", attribute45=" + attribute45 + ", attribute46=" + attribute46 + ", attribute47=" + attribute47
				+ ", attribute48=" + attribute48 + ", attribute49=" + attribute49 + ", attribute50=" + attribute50
				+ ", attribute51=" + attribute51 + ", attribute52=" + attribute52 + ", attribute53=" + attribute53
				+ ", attribute54=" + attribute54 + ", attribute55=" + attribute55 + ", attribute56=" + attribute56
				+ ", attribute57=" + attribute57 + ", attribute58=" + attribute58 + ", attribute59=" + attribute59
				+ ", attribute60=" + attribute60 + ", attribute61=" + attribute61 + ", attribute62=" + attribute62
				+ ", attribute63=" + attribute63 + ", attribute64=" + attribute64 + ", attribute65=" + attribute65
				+ ", attribute66=" + attribute66 + ", attribute67=" + attribute67 + ", attribute68=" + attribute68
				+ ", attribute69=" + attribute69 + ", attribute70=" + attribute70 + ", attribute71=" + attribute71
				+ ", attribute72=" + attribute72 + ", attribute73=" + attribute73 + ", attribute74=" + attribute74
				+ ", attribute75=" + attribute75 + ", attribute76=" + attribute76 + ", attribute77=" + attribute77
				+ ", attribute78=" + attribute78 + ", attribute79=" + attribute79 + ", attribute80=" + attribute80
				+ ", attribute81=" + attribute81 + ", attribute82=" + attribute82 + ", attribute83=" + attribute83
				+ ", attribute84=" + attribute84 + ", attribute85=" + attribute85 + ", attribute86=" + attribute86
				+ ", attribute87=" + attribute87 + ", attribute88=" + attribute88 + ", attribute89=" + attribute89
				+ ", attribute90=" + attribute90 + ", attribute91=" + attribute91 + ", attribute92=" + attribute92
				+ ", attribute93=" + attribute93 + ", attribute94=" + attribute94 + ", attribute95=" + attribute95
				+ ", attribute96=" + attribute96 + ", attribute97=" + attribute97 + ", attribute98=" + attribute98
				+ ", attribute99=" + attribute99 + ", attribute100=" + attribute100 + ", status=" + status + ", refNo="
				+ refNo + ", taxYear=" + taxYear + ", filingFreq=" + filingFreq + ", serviceType=" + serviceType
				+ ", formPrice=" + formPrice + ", digitalSignature=" + digitalSignature + ", batchId=" + batchId
				+ ", slabFlag=" + slabFlag + ", signName=" + signName + ", signPhone=" + signPhone + ", paymentId=" + paymentId + "]";
	}
	
}