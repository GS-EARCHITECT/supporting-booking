package resource_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the BOOKING_RESOURCE_MASTER database table.
 * 
 */
@Entity
@Table(name = "BOOKING_RESOURCE_MASTER")
public class BookingResourceMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BookingResourceMasterPK id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DISC_CODE")
	private String discCode;

	@Column(name = "DISC_PER")
	private double discPer;

	@Column(name = "DISC_VAL")
	private double discVal;

	@Column(name = "MAX_QTY")
	private double maxQty;

	@Column(name = "QOH")
	private double qoh;

	@Column(name = "QTY_CODE_SEQ_NO")
	private Long qtyCodeSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "REORDER_LEVEL")
	private Float reorderLevel;

	@Column(name = "REORDER_QTY")
	private Float reorderQty;

	@Column(name = "RESOURCE_ID")
	private String resourceId;

	@Column(name = "RESOURCEE_CATEGORY_SEQ_NO")
	private BigDecimal resourceeCategorySeqNo;

	@Column(name = "SPECI_FORMAT_SEQ_NO")
	private Float speciFormatSeqNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TAX_CODE")
	private String taxCode;

	@Column(name = "TAX_PER")
	private BigDecimal taxPer;

	@Column(name = "TAX_VAL")
	private Float taxVal;

	@Column(name = "UNIT_PRICE")
	private BigDecimal unitPrice;

	@Column(name = "UNIT_PRICE_SEQ_NO")
	private BigDecimal unitPriceSeqNo;

	public BookingResourceMaster() {
	}

	public BookingResourceMasterPK getId() {
		return id;
	}

	public void setId(BookingResourceMasterPK id) {
		this.id = id;
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

	public BookingResourceMaster(BookingResourceMasterPK id, String description, String discCode, double discPer,
			double discVal, double maxQty, double qoh, Long qtyCodeSeqNo, String remark, Float reorderLevel,
			Float reorderQty, String resourceId, BigDecimal resourceeCategorySeqNo, Float speciFormatSeqNo,
			String status, String taxCode, BigDecimal taxPer, Float taxVal, BigDecimal unitPrice,
			BigDecimal unitPriceSeqNo) {
		super();
		this.id = id;
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
	
}