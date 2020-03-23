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
@Table(name = "mt_tax_rates")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TaxRates extends BaseModelObject {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@Size(min = 0, max = 255)
	@Column(name = "product_name")
	private String productName;
	
	@Size(min = 0, max = 255)
	@Column(name = "product_category")
	private String productCategory;
	
	@Size(min = 0, max = 255)
	@Column(name = "item")
	private String item;
	
	@Size(min = 0, max = 255)
	@Column(name = "item_descrption")
	private String itemDescrption;
	
	@Size(min = 0, max = 255)
	@Column(name = "qty_range_low")
	private String qtyRangeLow;
	
	@Size(min = 0, max = 255)
	@Column(name = "qty_range_high")
	private String qtyRangeHigh;
	
	@Column(name = "rate")
	private Double rate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemDescrption() {
		return itemDescrption;
	}

	public void setItemDescrption(String itemDescrption) {
		this.itemDescrption = itemDescrption;
	}

	public String getQtyRangeLow() {
		return qtyRangeLow;
	}

	public void setQtyRangeLow(String qtyRangeLow) {
		this.qtyRangeLow = qtyRangeLow;
	}

	public String getQtyRangeHigh() {
		return qtyRangeHigh;
	}

	public void setQtyRangeHigh(String qtyRangeHigh) {
		this.qtyRangeHigh = qtyRangeHigh;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "TaxRates [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", item=" + item + ", itemDescrption=" + itemDescrption + ", qtyRangeLow=" + qtyRangeLow
				+ ", qtyRangeHigh=" + qtyRangeHigh + ", rate=" + rate + "]";
	}
	
	

}
