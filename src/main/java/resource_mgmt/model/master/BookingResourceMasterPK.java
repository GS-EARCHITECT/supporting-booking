package resource_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BOOKING_RESOURCE_MASTER database table.
 * 
 */
@Embeddable
public class BookingResourceMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_SEQ_NO")
	private long resourceSeqNo;

	@Column(name = "RESLOCATION_ID")
	private String reslocationId;

	@Column(name = "COMPANY_SEQ_NO")
	private long companySeqNo;

	public BookingResourceMasterPK() {
	}

	public long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public String getReslocationId() {
		return this.reslocationId;
	}

	public void setReslocationId(String reslocationId) {
		this.reslocationId = reslocationId;
	}

	public long getCompanySeqNo() {
		return this.companySeqNo;
	}

	public void setCompanySeqNo(long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BookingResourceMasterPK)) {
			return false;
		}
		BookingResourceMasterPK castOther = (BookingResourceMasterPK) other;
		return (this.resourceSeqNo == castOther.resourceSeqNo) && this.reslocationId.equals(castOther.reslocationId)
				&& (this.companySeqNo == castOther.companySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceSeqNo ^ (this.resourceSeqNo >>> 32)));
		hash = hash * prime + this.reslocationId.hashCode();
		hash = hash * prime + ((int) (this.companySeqNo ^ (this.companySeqNo >>> 32)));

		return hash;
	}

	public BookingResourceMasterPK(long resourceSeqNo, String reslocationId, long companySeqNo)
	{
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.reslocationId = reslocationId;
		this.companySeqNo = companySeqNo;
	}

}