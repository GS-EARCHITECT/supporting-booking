package resource_mgmt.model.repo;

import java.sql.Timestamp;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource_mgmt.model.master.BookingResourceDetail;

@Repository("bookingResourceDetailsRepo")
public interface BookingResourceDetailsRepo extends CrudRepository<BookingResourceDetail, Long> 
{
@Query(value = "select * from BOOKING_RESOURCE_DETAILS b where (rownum = 1 and b.alloc_seq_no = :allocSeqNo)",nativeQuery = true) 
BookingResourceDetail getNeededResourcesForAlloc(@Param(value = "allocSeqNo") Long allocSeqNo);

@Query(value = "select COALESCE(qoh,0) from BOOKING_RESOURCE_MASTER b where "
		+ "(rownum=1 and b.company_seq_no=:compSeqNo and b.resource_seq_no=:resSeqNo and "
		+ "trim(b.RESLOCATION_ID)=:resLocationId)",nativeQuery = true) 
Float checkResourceQoh(@Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocationId") String resLocationId);

@Modifying
@Query(value="update BOOKING_RESOURCE_MASTER b set QOH = QOH - :qoh where (b.company_seq_no=:compSeqNo and b.resource_seq_no=:resSeqNo and b.RESLOCATION_ID=:resLocationSeqNo)", nativeQuery = true)
void updateResourceMasterDeductQty(@Param("qoh") Float qoh, @Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocationSeqNo") String resLocationSeqNo);;

@Modifying
@Query(value="update BOOKING_RESOURCE_DETAILS set QTY_ALLOCATED = QTY_ALLOCATED + :neededQty where ALLOC_SEQ_NO = :allocSeqNo", nativeQuery = true)
void updateServiceResourceAlloc(@Param(value = "neededQty") float neededQty, @Param(value = "allocSeqNo") Long allocSeqNo);

@Query(value = "select COALESCE(SUM(qty_requested),0) from BOOKING_RESOURCE_DETAILS b where "
		+ "("
		+ "b.ALLOC_SEQ_NO IS NOT NULL and b.ALLOC_SEQ_NO < :allocSeqNo and "
		+ "b.resource_seq_no=:resSeqNo and b.company_seq_no=:compSeqNo and "
		+"((b.FROM_DTTM IS NULL and b.TO_DTTM IS NULL) or ((b.FROM_DTTM < systimestamp) or "
		+ "(b.TO_DTTM < systimestamp))) and ((upper(b.delete_flag)!='Y' or b.delete_flag IS NULL) and "
		+ "trim(b.RESOURCE_LOCATION_ID)=:resLocId))",nativeQuery = true) 
Float checkAlreadyResourcesRequestedFCFSBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocId") String resLocId);

@Query(value = "select COALESCE(SUM(qty_requested),0) from BOOKING_RESOURCE_DETAILS b where "
		+ "("
		+ "b.ALLOC_SEQ_NO IS NOT NULL and b.ALLOC_SEQ_NO < :allocSeqNo and "
		+ "b.resource_seq_no=:resSeqNo and b.company_seq_no=:compSeqNo and "
		+ "((:frDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) or (:toDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) and"
		+ "b.FROM_DTTM IS NOT NULL and b.TO_DTTM IS NOT NULL) and "
		+ "and ((upper(b.delete_flag)!='Y' or b.delete_flag IS NULL) and "
		+ "trim(b.RESOURCE_LOCATION_ID)=:resLocId))",nativeQuery = true) 
Float checkAlreadyResourcesRequestedTimeBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocId") String resLocId, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

@Query(value = "select COALESCE(SUM(qty_allocated),0) from BOOKING_RESOURCE_DETAILS b where "
		+ "(b.ALLOC_SEQ_NO < :allocSeqNo and b.resource_seq_no=:resSeqNo and "
		+ "b.company_seq_no=:compSeqNo and b.RESOURCE_LOCATION_ID=:resLocId) and"
		+ "(upper(b.delete_flag)!='Y' or b.delete_flag IS NULL) and "
		+ "(b.FROM_DTTM IS NULL or b.TO_DTTM IS NULL)",nativeQuery = true) 
Float checkAlreadyResourcesAllocatedFCFSBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocId") String resLocId);

@Query(value = "select COALESCE(SUM(qty_allocated),0) from BOOKING_RESOURCE_DETAILS b where "
		+ "(b.ALLOC_SEQ_NO < :allocSeqNo and b.resource_seq_no=:resSeqNo and "
		+ "b.company_seq_no=:compSeqNo and b.RESOURCE_LOCATION_ID=:resLocId) and"
		+ "((:frDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) or (:toDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) and"
		+ "(upper(b.delete_flag)!='Y' or b.delete_flag IS NULL) and "
		+ "b.FROM_DTTM IS NOT NULL and b.TO_DTTM IS NOT NULL)",nativeQuery = true) 
Float checkAlreadyResourcesAllocatedTimeBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("resSeqNo") Long resSeqNo, @Param("compSeqNo") Long compSeqNo, @Param("resLocId") String resLocId, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

}
