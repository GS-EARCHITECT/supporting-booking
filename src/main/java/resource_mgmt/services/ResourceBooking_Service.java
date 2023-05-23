package resource_mgmt.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_mgmt.model.master.BookingAssetDetail;
import resource_mgmt.model.master.BookingResourceDetail;
import resource_mgmt.model.repo.BookingAssetDetailsRepo;
import resource_mgmt.model.repo.BookingResourceDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("resourceBookingMgmtServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceBooking_Service implements I_ResourceBooking_Service {

	private static final Logger logger = LoggerFactory.getLogger(ResourceBooking_Service.class);

	@Autowired
	private BookingAssetDetailsRepo bookingAssetDetailsRepo;

	@Autowired
	private BookingResourceDetailsRepo bookingResourceDetailsRepo;

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Long resource_Alloc_Asset(Long companySeqNo, Long assetSeqNo, String assetLocationId, String frDtTm,
			String toDtTm) {
		Long allocSeqno = (long) -1;

		if (companySeqNo != null && assetSeqNo != null && assetLocationId != null) {
			BookingAssetDetail bookingAssetDetail = new BookingAssetDetail();

			if (frDtTm != null && toDtTm != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				LocalDateTime fdt = LocalDateTime.parse(frDtTm, formatter);
				LocalDateTime tdt = LocalDateTime.parse(toDtTm, formatter);
				Timestamp fromDate = Timestamp.valueOf(fdt);
				Timestamp toDate = Timestamp.valueOf(tdt);
				bookingAssetDetail.setFromDttm(fromDate);
				bookingAssetDetail.setToDttm(toDate);
			} else {
				bookingAssetDetail.setFromDttm(null);
				bookingAssetDetail.setToDttm(null);
			}

			bookingAssetDetail.setAllocated(' ');
			bookingAssetDetail.setAssetSeqNo(assetSeqNo);
			bookingAssetDetail.setCompanySeqNo(companySeqNo);
			bookingAssetDetail.setAsset_loc_id(assetLocationId);
			bookingAssetDetail.setStatus("");
			bookingAssetDetail.setRemark("");
			BookingAssetDetail bookingAssetDetail2 = bookingAssetDetailsRepo.save(bookingAssetDetail);
			allocSeqno = res_assets_Strictprocess(bookingAssetDetail2.getAlloc_seq_no());
		}
		return allocSeqno;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Long resource_Alloc_Cate(Long companySeqNo, Long resSeqNo, String resLocationId, String frDtTm,
			String toDtTm, Long qtySeqNo, Float qty) {
		Long allocSeqno = (long) -1;
		if (companySeqNo != null && resSeqNo != null && resLocationId != null) {
			BookingResourceDetail bookingResourceDetail = null;
			BookingResourceDetail bookingResourceDetail2 = null;
			bookingResourceDetail = new BookingResourceDetail();

			if (frDtTm != null && toDtTm != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				LocalDateTime fdt = LocalDateTime.parse(frDtTm, formatter);
				LocalDateTime tdt = LocalDateTime.parse(toDtTm, formatter);
				Timestamp fromDate = Timestamp.valueOf(fdt);
				Timestamp toDate = Timestamp.valueOf(tdt);
				bookingResourceDetail.setFromDttm(fromDate);
				bookingResourceDetail.setToDttm(toDate);
			} else {
				bookingResourceDetail.setFromDttm(null);
				bookingResourceDetail.setToDttm(null);
			}

			bookingResourceDetail.setCompanySeqNo(companySeqNo);
			bookingResourceDetail.setQtyRequested(qty);
			bookingResourceDetail.setQtyAllocated((float) 0);
			bookingResourceDetail.setQtyBooked((float) 0);
			bookingResourceDetail.setIsBooked(' ');
			bookingResourceDetail.setResourceSeqNo(resSeqNo);
			bookingResourceDetail.setResourceLocId(resLocationId);
			bookingResourceDetail.setStatus("");
			bookingResourceDetail.setRemark("");
			bookingResourceDetail2 = bookingResourceDetailsRepo.save(bookingResourceDetail);
			allocSeqno = res_cate_Strictprocess(bookingResourceDetail2.getAllocSeqNo());
		}
		return allocSeqno;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Long res_assets_Strictprocess(Long allocSeqNo) {
		BookingAssetDetail bookingAssetDetails = bookingAssetDetailsRepo.getNeededAssetsForAlloc(allocSeqNo);
		Long ass_seq_no_curr = (long) 0;
		Long alloc_seq_no_curr = (long) 0;
		Timestamp frDtTm = null;
		Timestamp toDtTm = null;
		Long bookCnt = (long) 0;
		String resLocId = null;

		if (bookingAssetDetails != null) {
			ass_seq_no_curr = bookingAssetDetails.getAssetSeqNo();
			alloc_seq_no_curr = bookingAssetDetails.getAlloc_seq_no();
			frDtTm = bookingAssetDetails.getFromDttm();
			toDtTm = bookingAssetDetails.getToDttm();
			resLocId = bookingAssetDetails.getAsset_loc_id();

			if (frDtTm == null || toDtTm == null) {
				bookCnt = bookingAssetDetailsRepo.checkAlreadyAssetRequestedFCFSBasis(alloc_seq_no_curr,
						ass_seq_no_curr, resLocId.trim());
				if (bookCnt > 0) {
					bookingAssetDetailsRepo.deleteById(alloc_seq_no_curr);
					alloc_seq_no_curr = (long) -1;
				}
			}

			if (frDtTm != null || toDtTm != null) {
				bookCnt = bookingAssetDetailsRepo.checkAlreadyAssetRequestedTimeBasis(alloc_seq_no_curr,
						ass_seq_no_curr, resLocId.trim(), frDtTm, toDtTm);
				if (bookCnt > 0) {
					bookingAssetDetailsRepo.deleteById(alloc_seq_no_curr);
					alloc_seq_no_curr = (long) -1;
				}
			}
		}
		return alloc_seq_no_curr;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Long res_cate_Strictprocess(Long allocSeqNo) {
		BookingResourceDetail cateAllocDetail = bookingResourceDetailsRepo.getNeededResourcesForAlloc(allocSeqNo);
		Long res_seq_no_curr = (long) 0;
		Long alloc_seq_no_curr = (long) 0;
		float needed_qty = (float) 0;
		float allocated_qty = (float) 0;
		float req_qty = (float) 0;
		float book_qty = (float) 0;
		Long companySeqNo = (long) 0;
		String resLocId = null;
		float eqoh = (float) 0;
		Float qoh = (float) 0;
		float eff = (float) 0;
		Timestamp frDtTm = null;
		Timestamp toDtTm = null;
		// StoreIssueMaster sMaster = null;

		if (cateAllocDetail != null) {
			book_qty = 0;
			res_seq_no_curr = cateAllocDetail.getResourceSeqNo();
			resLocId = cateAllocDetail.getResourceLocId();
			companySeqNo = cateAllocDetail.getCompanySeqNo();
			frDtTm = cateAllocDetail.getFromDttm();
			toDtTm = cateAllocDetail.getToDttm();
			alloc_seq_no_curr = cateAllocDetail.getAllocSeqNo();
			needed_qty = cateAllocDetail.getQtyRequested() - cateAllocDetail.getQtyAllocated();
			req_qty = cateAllocDetail.getQtyAllocated();
			allocated_qty = cateAllocDetail.getQtyAllocated();

			qoh = bookingResourceDetailsRepo.checkResourceQoh(res_seq_no_curr, companySeqNo, resLocId.trim());
			eff = getEffectiveResourceQoh(alloc_seq_no_curr, res_seq_no_curr, companySeqNo, resLocId.trim(), frDtTm,
					toDtTm);
			eqoh = qoh - eff;

			if (needed_qty > 0) {
				if (eqoh > 0) {
					if (needed_qty <= eqoh) 
					{
						bookingResourceDetailsRepo.updateResourceMasterDeductQty(needed_qty, res_seq_no_curr,
								companySeqNo, resLocId.trim());
						bookingResourceDetailsRepo.updateServiceResourceAlloc(needed_qty, alloc_seq_no_curr);
						// sMaster = createIssueRecord(store_seq_no_curr, item_seq_no_curr, needed_qty);
						// storeIssueRepo.save(sMaster);
					} 
					else 
					{
						bookingResourceDetailsRepo.deleteById(alloc_seq_no_curr);
						alloc_seq_no_curr = (long) -1;
					}
				}
			}

		}

		return alloc_seq_no_curr;
	}

	private float getEffectiveResourceQoh(Long allocSeqNo, Long resSeqNo, Long compSeqNo, String resLocId,
			Timestamp frDtTm, Timestamp toDtTm) {
		float eff_totReqQty = 0;
		float eff_totAllocQty = 0;

		if (frDtTm == null || toDtTm == null) {
			eff_totReqQty = bookingResourceDetailsRepo.checkAlreadyResourcesRequestedFCFSBasis(allocSeqNo, resSeqNo,
					compSeqNo, resLocId.trim());
			eff_totAllocQty = bookingResourceDetailsRepo.checkAlreadyResourcesAllocatedFCFSBasis(allocSeqNo, resSeqNo,
					compSeqNo, resLocId.trim());
		} else {
			eff_totReqQty = bookingResourceDetailsRepo.checkAlreadyResourcesRequestedTimeBasis(allocSeqNo, resSeqNo,
					compSeqNo, resLocId.trim(), frDtTm, toDtTm);
			eff_totAllocQty = bookingResourceDetailsRepo.checkAlreadyResourcesAllocatedTimeBasis(allocSeqNo, resSeqNo,
					compSeqNo, resLocId.trim(), frDtTm, toDtTm);
		}

		return (eff_totReqQty - eff_totAllocQty);
	}
}