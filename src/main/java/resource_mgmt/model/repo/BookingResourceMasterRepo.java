package resource_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_mgmt.model.master.BookingResourceMaster;
import resource_mgmt.model.master.BookingResourceMasterPK;

@Repository("bookingResourceMasterRepo")
public interface BookingResourceMasterRepo extends CrudRepository<BookingResourceMaster, BookingResourceMasterPK> 
{
	@Query(value = "SELECT * FROM BOOKING_RESOURCE_MASTER a WHERE a.resource_category_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<BookingResourceMaster> getSelectResourcesByCategories(@Param("ids") ArrayList<BigDecimal> ids);

	@Query(value = "SELECT * FROM BOOKING_RESOURCE_MASTER a WHERE a.resource_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<BookingResourceMaster> getSelectResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM BOOKING_RESOURCE_MASTER a WHERE a.company_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<BookingResourceMaster> getSelectResourcesByCompanies(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT coalesce(qoh,0) FROM BOOKING_RESOURCE_MASTER a WHERE a.resource_seq_no = :id", nativeQuery = true)
	Float getResourceQoh(@Param("id") Long id);
		
	@Query(value = "update BOOKING_RESOURCE_MASTER set qoh = qoh + :qty WHERE a.resource_seq_no = :id", nativeQuery = true)
	Float setResourceQoh(@Param("id") Long id, @Param("qty") Float qty);
	
	@Query(value = "SELECT * FROM BOOKING_RESOURCE_MASTER a WHERE a.unit_price>=:fr and a.unit_price<=:to order by resource_seq_no", nativeQuery = true)
	ArrayList<BookingResourceMaster> getSelectResourcesByPriceRange(@Param("fr") Float fr, @Param("to") Float to);
	
	@Query(value = "DELETE FROM BOOKING_RESOURCE_MASTER WHERE a.resource_type_seq_no in :ids", nativeQuery = true)
	void delSelectResources(@Param("ids") ArrayList<Long> ids);
}
