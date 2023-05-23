package resource_mgmt.model.repo;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_mgmt.model.master.BookingAssetDetail;

@Repository("bookingAssetDetailsRepo")
public interface BookingAssetDetailsRepo extends CrudRepository<BookingAssetDetail, Long> 
{
	@Query(value = "select * from BOOKING_ASSET_DETAILS b where (rownum = 1 and b.alloc_seq_no = :allocSeqNo)",nativeQuery = true) 
	BookingAssetDetail getNeededAssetsForAlloc(@Param(value = "allocSeqNo") Long allocSeqNo);

	@Query(value = "select COALESCE(count(*),0) from BOOKING_ASSET_DETAILS b where "
			+ "("
			+ "(trim(b.asset_LOCATION_ID) = :assetLocationId and b.ALLOC_SEQ_NO < :allocSeqNo and"
			+ " b.asset_seq_no=:assetSeqNo) and"
			+ "((:frDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) or (:toDtTm BETWEEN b.FROM_DTTM and b.TO_DTTM) and"
			+ " b.FROM_DTTM IS NOT NULL and b.TO_DTTM IS NOT NULL) and"
			+ "(b.delete_flag IS NULL or upper(b.delete_flag)!='Y') and "
			+ "(upper(b.allocated)!='Y' or b.ALLOCATED IS NULL)"
			+ ")",nativeQuery = true) 
	Long checkAlreadyAssetRequestedTimeBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("assetLocationId") String assetLocationId, @Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "select coalesce(count(*),0) from BOOKING_ASSET_DETAILS b where "
			+ "("
			+ "(trim(b.ASSET_LOCATION_ID) = :assetLocationId and "
			+ "b.ALLOC_SEQ_NO < :allocSeqNo and b.asset_seq_no= :assetSeqNo) and " 
			+ "((b.FROM_DTTM IS NULL and b.TO_DTTM IS NULL) or "
			+ "((b.FROM_DTTM < systimestamp) or "
			+ "(b.TO_DTTM < systimestamp))) and "
			+ "((upper(b.delete_flag)!='Y' or b.delete_flag IS NULL) and "
			+ "(upper(b.allocated)!='Y' or b.ALLOCATED IS NULL))"
			+ ")",nativeQuery = true) 
	Long checkAlreadyAssetRequestedFCFSBasis(@Param("allocSeqNo") Long allocSeqNo, @Param("assetSeqNo") Long assetSeqNo, @Param("assetLocationId") String assetLocationId);	
}