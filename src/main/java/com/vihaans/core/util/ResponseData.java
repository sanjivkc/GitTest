package com.vihaans.core.util;

import java.util.List;
import java.util.Map;

public class ResponseData {

	private String type;
	private Long length;
	private String status;
	private String message;
	private Object data;
	private List<Object> childList;
	private List<Map<String, Object>> shortDataList;
	private List<Map<String, Object>> shortDataList1094;
	private Double amountValue;
	private Object smallDataList;
	
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	
	private Long attribute6;
	private Long attribute7;
	private Long attribute8;
	private Long attribute9;
	private Long attribute10;
	
	private List<Map<String, Object>> attribute11;
	private List<Map<String, Object>> attribute12;
	private List<Map<String, Object>> attribute13;
	private List<Map<String, Object>> attribute14;
	private List<Map<String, Object>> attribute15;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	public void setShortDataList(List<Map<String, Object>> shortDataList) {
		this.shortDataList=shortDataList;
	}
	
	public List<Map<String, Object>> getShortDataList(){
		return shortDataList;
	}

	public List<Map<String, Object>> getShortDataList1094() {
		return shortDataList1094;
	}

	public void setShortDataList1094(List<Map<String, Object>> shortDataList1094) {
		this.shortDataList1094 = shortDataList1094;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(Double amountValue) {
		this.amountValue = amountValue;
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

	public Long getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(Long attribute6) {
		this.attribute6 = attribute6;
	}

	public Long getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(Long attribute7) {
		this.attribute7 = attribute7;
	}

	public Long getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(Long attribute8) {
		this.attribute8 = attribute8;
	}

	public Long getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(Long attribute9) {
		this.attribute9 = attribute9;
	}

	public Long getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(Long attribute10) {
		this.attribute10 = attribute10;
	}

	public List<Map<String, Object>> getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(List<Map<String, Object>> attribute11) {
		this.attribute11 = attribute11;
	}

	public List<Map<String, Object>> getAttribute12() {
		return attribute12;
	}

	public void setAttribute12(List<Map<String, Object>> attribute12) {
		this.attribute12 = attribute12;
	}

	public List<Map<String, Object>> getAttribute13() {
		return attribute13;
	}

	public void setAttribute13(List<Map<String, Object>> attribute13) {
		this.attribute13 = attribute13;
	}

	public List<Map<String, Object>> getAttribute14() {
		return attribute14;
	}

	public void setAttribute14(List<Map<String, Object>> attribute14) {
		this.attribute14 = attribute14;
	}

	public List<Map<String, Object>> getAttribute15() {
		return attribute15;
	}

	public void setAttribute15(List<Map<String, Object>> attribute15) {
		this.attribute15 = attribute15;
	}

	public Object getSmallDataList() {
		return smallDataList;
	}

	public void setSmallDataList(Object smallDataList) {
		this.smallDataList = smallDataList;
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setChildList(List<Object> childList) {
		this.childList = childList;
	}
	
}