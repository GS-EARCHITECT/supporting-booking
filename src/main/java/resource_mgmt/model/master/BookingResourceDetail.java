package resource_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the BOOKING_RESOURCE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "BOOKING_RESOURCE_DETAILS")
public class BookingResourceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_resource_alloc_seq_no")
	@SequenceGenerator(name = "booking_resource_alloc_seq_no", sequenceName = "booking_resource_alloc_seq_no", allocationSize = 1)
	@Column(name = "ALLOC_SEQ_NO")
	private long allocSeqNo;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "DELETE_FLAG")
	private Character deleteFlag;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDttm;

	@Column(name = "IS_BOOKED")
	private Character isBooked;

	@Column(name = "QTY_ALLOCATED")
	private Float qtyAllocated;

	@Column(name = "QTY_BOOKED")
	private Float qtyBooked;

	@Column(name = "QTY_REQUESTED")
	private Float qtyRequested;

	@Column(name = "QTY_SEQ_NO")
	private Long qtySeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	@Column(name = "RESOURCE_LOCATION_ID")
	private String resourceLocId;

	public long getAllocSeqNo() {
		return allocSeqNo;
	}

	public void setAllocSeqNo(long allocSeqNo) {
		this.allocSeqNo = allocSeqNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Character getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Character deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Timestamp getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(Timestamp fromDttm) {
		this.fromDttm = fromDttm;
	}

	public Character getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Float getQtyAllocated() {
		return qtyAllocated;
	}

	public void setQtyAllocated(Float qtyAllocated) {
		this.qtyAllocated = qtyAllocated;
	}

	public Float getQtyBooked() {
		return qtyBooked;
	}

	public void setQtyBooked(Float qtyBooked) {
		this.qtyBooked = qtyBooked;
	}

	public Float getQtyRequested() {
		return qtyRequested;
	}

	public void setQtyRequested(Float qtyRequested) {
		this.qtyRequested = qtyRequested;
	}

	public Long getQtySeqNo() {
		return qtySeqNo;
	}

	public void setQtySeqNo(Long qtySeqNo) {
		this.qtySeqNo = qtySeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Timestamp getToDttm() {
		return toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public String getResourceLocId() {
		return resourceLocId;
	}

	public void setResourceLocId(String resourceLocId) {
		this.resourceLocId = resourceLocId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (allocSeqNo ^ (allocSeqNo >>> 32));
		result = prime * result + ((companySeqNo == null) ? 0 : companySeqNo.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((fromDttm == null) ? 0 : fromDttm.hashCode());
		result = prime * result + ((isBooked == null) ? 0 : isBooked.hashCode());
		result = prime * result + ((qtyAllocated == null) ? 0 : qtyAllocated.hashCode());
		result = prime * result + ((qtyBooked == null) ? 0 : qtyBooked.hashCode());
		result = prime * result + ((qtyRequested == null) ? 0 : qtyRequested.hashCode());
		result = prime * result + ((qtySeqNo == null) ? 0 : qtySeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceLocId == null) ? 0 : resourceLocId.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toDttm == null) ? 0 : toDttm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingResourceDetail other = (BookingResourceDetail) obj;
		if (allocSeqNo != other.allocSeqNo)
			return false;
		if (companySeqNo == null) {
			if (other.companySeqNo != null)
				return false;
		} else if (!companySeqNo.equals(other.companySeqNo))
			return false;
		if (deleteFlag == null) {
			if (other.deleteFlag != null)
				return false;
		} else if (!deleteFlag.equals(other.deleteFlag))
			return false;
		if (fromDttm == null) {
			if (other.fromDttm != null)
				return false;
		} else if (!fromDttm.equals(other.fromDttm))
			return false;
		if (isBooked == null) {
			if (other.isBooked != null)
				return false;
		} else if (!isBooked.equals(other.isBooked))
			return false;
		if (qtyAllocated == null) {
			if (other.qtyAllocated != null)
				return false;
		} else if (!qtyAllocated.equals(other.qtyAllocated))
			return false;
		if (qtyBooked == null) {
			if (other.qtyBooked != null)
				return false;
		} else if (!qtyBooked.equals(other.qtyBooked))
			return false;
		if (qtyRequested == null) {
			if (other.qtyRequested != null)
				return false;
		} else if (!qtyRequested.equals(other.qtyRequested))
			return false;
		if (qtySeqNo == null) {
			if (other.qtySeqNo != null)
				return false;
		} else if (!qtySeqNo.equals(other.qtySeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (resourceLocId == null) {
			if (other.resourceLocId != null)
				return false;
		} else if (!resourceLocId.equals(other.resourceLocId))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

	public BookingResourceDetail(long allocSeqNo, Long companySeqNo, Character deleteFlag, Timestamp fromDttm,
			Character isBooked, Float qtyAllocated, Float qtyBooked, Float qtyRequested, Long qtySeqNo, String remark,
			String status, Long resourceSeqNo, Timestamp toDttm, String resourceLocId) {
		super();
		this.allocSeqNo = allocSeqNo;
		this.companySeqNo = companySeqNo;
		this.deleteFlag = deleteFlag;
		this.fromDttm = fromDttm;
		this.isBooked = isBooked;
		this.qtyAllocated = qtyAllocated;
		this.qtyBooked = qtyBooked;
		this.qtyRequested = qtyRequested;
		this.qtySeqNo = qtySeqNo;
		this.remark = remark;
		this.status = status;
		this.resourceSeqNo = resourceSeqNo;
		this.toDttm = toDttm;
		this.resourceLocId = resourceLocId;
	}

	public BookingResourceDetail() {
		super();
	}

}