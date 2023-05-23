package resource_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookingResourceMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3834615389477130118L;
	private long resourceSeqNo;
	private String reslocationId;
	private long companySeqNo;
	private String description;
	private String discCode;
	private double discPer;
	private double discVal;
	private double maxQty;
	private double qoh;
	private Long qtyCodeSeqNo;
	private String remark;
	private Float reorderLevel;
	private Float reorderQty;
	private String resourceId;
	private BigDecimal resourceeCategorySeqNo;
	private Float speciFormatSeqNo;
	private String status;
	private String taxCode;
	private BigDecimal taxPer;
	private Float taxVal;
	private BigDecimal unitPrice;
	private BigDecimal unitPriceSeqNo;

	public long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public String getReslocationId() {
		return reslocationId;
	}

	public void setReslocationId(String reslocationId) {
		this.reslocationId = reslocationId;
	}

	public long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscCode() {
		return discCode;
	}

	public void setDiscCode(String discCode) {
		this.discCode = discCode;
	}

	public double getDiscPer() {
		return discPer;
	}

	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}

	public double getDiscVal() {
		return discVal;
	}

	public void setDiscVal(double discVal) {
		this.discVal = discVal;
	}

	public double getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(double maxQty) {
		this.maxQty = maxQty;
	}

	public double getQoh() {
		return qoh;
	}

	public void setQoh(double qoh) {
		this.qoh = qoh;
	}

	public Long getQtyCodeSeqNo() {
		return qtyCodeSeqNo;
	}

	public void setQtyCodeSeqNo(Long qtyCodeSeqNo) {
		this.qtyCodeSeqNo = qtyCodeSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Float getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Float reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Float getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(Float reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public BigDecimal getResourceeCategorySeqNo() {
		return resourceeCategorySeqNo;
	}

	public void setResourceeCategorySeqNo(BigDecimal resourceeCategorySeqNo) {
		this.resourceeCategorySeqNo = resourceeCategorySeqNo;
	}

	public Float getSpeciFormatSeqNo() {
		return speciFormatSeqNo;
	}

	public void setSpeciFormatSeqNo(Float speciFormatSeqNo) {
		this.speciFormatSeqNo = speciFormatSeqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public BigDecimal getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(BigDecimal taxPer) {
		this.taxPer = taxPer;
	}

	public Float getTaxVal() {
		return taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPriceSeqNo() {
		return unitPriceSeqNo;
	}

	public void setUnitPriceSeqNo(BigDecimal unitPriceSeqNo) {
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	public BookingResourceMasterDTO(long resourceSeqNo, String reslocationId, long companySeqNo, String description,
			String discCode, double discPer, double discVal, double maxQty, double qoh, Long qtyCodeSeqNo,
			String remark, Float reorderLevel, Float reorderQty, String resourceId, BigDecimal resourceeCategorySeqNo,
			Float speciFormatSeqNo, String status, String taxCode, BigDecimal taxPer, Float taxVal,
			BigDecimal unitPrice, BigDecimal unitPriceSeqNo) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.reslocationId = reslocationId;
		this.companySeqNo = companySeqNo;
		this.description = description;
		this.discCode = discCode;
		this.discPer = discPer;
		this.discVal = discVal;
		this.maxQty = maxQty;
		this.qoh = qoh;
		this.qtyCodeSeqNo = qtyCodeSeqNo;
		this.remark = remark;
		this.reorderLevel = reorderLevel;
		this.reorderQty = reorderQty;
		this.resourceId = resourceId;
		this.resourceeCategorySeqNo = resourceeCategorySeqNo;
		this.speciFormatSeqNo = speciFormatSeqNo;
		this.status = status;
		this.taxCode = taxCode;
		this.taxPer = taxPer;
		this.taxVal = taxVal;
		this.unitPrice = unitPrice;
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	public BookingResourceMasterDTO() {
		super();
	}
}