package resource_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the BOOKING_ASSET_DETAILS database table.
 * 
 */
@Entity
@Table(name = "BOOKING_ASSET_DETAILS")
public class BookingAssetDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_asset_alloc_seq_no")
	@SequenceGenerator(name = "booking_asset_alloc_seq_no", sequenceName = "booking_asset_alloc_seq_no", allocationSize = 1)
	@Column(name = "ALLOC_SEQ_NO")
	private Long alloc_seq_no;

	@Column(name = "ALLOCATED")
	private Character allocated;

	@Column(name = "ASSET_LOCATION_ID")
	private String asset_loc_id;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "DELETE_FLAG")
	private Character deleteFlag;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDttm;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public String getAsset_loc_id() {
		return asset_loc_id;
	}

	public void setAsset_loc_id(String asset_loc_id) {
		this.asset_loc_id = asset_loc_id;
	}

	public Long getAlloc_seq_no() {
		return alloc_seq_no;
	}

	public void setAlloc_seq_no(Long alloc_seq_no) {
		this.alloc_seq_no = alloc_seq_no;
	}

	public Character getAllocated() {
		return allocated;
	}

	public void setAllocated(Character allocated) {
		this.allocated = allocated;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
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

	public Timestamp getToDttm() {
		return toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public BookingAssetDetail(Long alloc_seq_no, Character allocated, String asset_loc_id, Long assetSeqNo,
			Long companySeqNo, Character deleteFlag, Timestamp fromDttm, String remark, String status,
			Timestamp toDttm) {
		super();
		this.alloc_seq_no = alloc_seq_no;
		this.allocated = allocated;
		this.asset_loc_id = asset_loc_id;
		this.assetSeqNo = assetSeqNo;
		this.companySeqNo = companySeqNo;
		this.deleteFlag = deleteFlag;
		this.fromDttm = fromDttm;
		this.remark = remark;
		this.status = status;
		this.toDttm = toDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alloc_seq_no == null) ? 0 : alloc_seq_no.hashCode());
		result = prime * result + ((allocated == null) ? 0 : allocated.hashCode());
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((asset_loc_id == null) ? 0 : asset_loc_id.hashCode());
		result = prime * result + ((companySeqNo == null) ? 0 : companySeqNo.hashCode());
		result = prime * result + ((deleteFlag == null) ? 0 : deleteFlag.hashCode());
		result = prime * result + ((fromDttm == null) ? 0 : fromDttm.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		BookingAssetDetail other = (BookingAssetDetail) obj;
		if (alloc_seq_no == null) {
			if (other.alloc_seq_no != null)
				return false;
		} else if (!alloc_seq_no.equals(other.alloc_seq_no))
			return false;
		if (allocated == null) {
			if (other.allocated != null)
				return false;
		} else if (!allocated.equals(other.allocated))
			return false;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (asset_loc_id == null) {
			if (other.asset_loc_id != null)
				return false;
		} else if (!asset_loc_id.equals(other.asset_loc_id))
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
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
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

	public BookingAssetDetail() {
		super();
	}

}