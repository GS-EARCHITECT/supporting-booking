package resource_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_mgmt.model.dto.BookingResourceMasterDTO;
import resource_mgmt.model.master.BookingResourceMaster;
import resource_mgmt.model.master.BookingResourceMasterPK;
import resource_mgmt.model.repo.BookingResourceMasterRepo;

@Service("resourceBookingMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class BookingResourceMasterService implements I_BookingResourceMasterService {

	@Autowired
	private BookingResourceMasterRepo bookingResourceMasterRepo;

	public BookingResourceMasterDTO newBookingResourceMaster(BookingResourceMasterDTO lMaster) 
	{
		BookingResourceMasterPK bookingResourceMasterPK = new BookingResourceMasterPK();
		bookingResourceMasterPK.setCompanySeqNo(lMaster.getCompanySeqNo());
		bookingResourceMasterPK.setReslocationId(lMaster.getReslocationId());
		bookingResourceMasterPK.setResourceSeqNo(lMaster.getResourceSeqNo());		
		Optional<BookingResourceMaster> resOptional = bookingResourceMasterRepo.findById(bookingResourceMasterPK);
		BookingResourceMaster bookingResourceMaster = null;
		BookingResourceMasterDTO bookingResourceMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		bookingResourceMaster = this.setBookingResourceMaster(lMaster);
		bookingResourceMaster.setId(bookingResourceMasterPK);
		bookingResourceMasterDTO=getBookingResourceMasterDTO(bookingResourceMasterRepo.save(bookingResourceMaster));
		}	
		return bookingResourceMasterDTO;
	}

	public ArrayList<BookingResourceMasterDTO> getAllBookingResourceMasters() 
	{
		ArrayList<BookingResourceMaster> resourceList = (ArrayList<BookingResourceMaster>) bookingResourceMasterRepo.findAll();
		ArrayList<BookingResourceMasterDTO> lMasterss = new ArrayList<BookingResourceMasterDTO>();
		lMasterss = resourceList != null ? this.getBookingResourceMasterDTOs(resourceList) : null;
		return lMasterss;
	}

	public ArrayList<BookingResourceMasterDTO> getSelectResources(ArrayList<Long> ids)
	{
		ArrayList<BookingResourceMaster> lMasters = bookingResourceMasterRepo.getSelectResources(ids);
		ArrayList<BookingResourceMasterDTO> BookingResourceMasterDTOs = new ArrayList<BookingResourceMasterDTO>();
		BookingResourceMasterDTO BookingResourceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			BookingResourceMasterDTO = this.getBookingResourceMasterDTO(lMasters.get(i));
			BookingResourceMasterDTOs.add(BookingResourceMasterDTO);
		}
		}
		return BookingResourceMasterDTOs;
	}
   
	public ArrayList<BookingResourceMasterDTO> getSelectResourcesByPriceRange(Float fr, Float to)
	{
		ArrayList<BookingResourceMaster> lMasters = bookingResourceMasterRepo.getSelectResourcesByPriceRange(fr, to);
		ArrayList<BookingResourceMasterDTO> BookingResourceMasterDTOs = new ArrayList<BookingResourceMasterDTO>();
		BookingResourceMasterDTO BookingResourceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			BookingResourceMasterDTO = this.getBookingResourceMasterDTO(lMasters.get(i));
			BookingResourceMasterDTOs.add(BookingResourceMasterDTO);
		}
		}
		return BookingResourceMasterDTOs;
	}

	
	public ArrayList<BookingResourceMasterDTO> getSelectResourcesByCategories(ArrayList<BigDecimal> ids)
	{
		ArrayList<BookingResourceMaster> lMasters = bookingResourceMasterRepo.getSelectResourcesByCategories(ids);
		ArrayList<BookingResourceMasterDTO> BookingResourceMasterDTOs = new ArrayList<BookingResourceMasterDTO>();
		BookingResourceMasterDTO BookingResourceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			BookingResourceMasterDTO = this.getBookingResourceMasterDTO(lMasters.get(i));
			BookingResourceMasterDTOs.add(BookingResourceMasterDTO);
		}
		}
		return BookingResourceMasterDTOs;
	}

	public ArrayList<BookingResourceMasterDTO> getSelectResourcesByCompanies(ArrayList<Long> ids)
	{
		ArrayList<BookingResourceMaster> lMasters = bookingResourceMasterRepo.getSelectResourcesByCompanies(ids);
		ArrayList<BookingResourceMasterDTO> BookingResourceMasterDTOs = new ArrayList<BookingResourceMasterDTO>();
		BookingResourceMasterDTO BookingResourceMasterDTO = null;

		if (lMasters!=null) 
		{
		for (int i = 0; i < lMasters.size(); i++) {
			BookingResourceMasterDTO = this.getBookingResourceMasterDTO(lMasters.get(i));
			BookingResourceMasterDTOs.add(BookingResourceMasterDTO);
		}
		}
		return BookingResourceMasterDTOs;
	}

	
	public BookingResourceMasterDTO getBookingResourceMasterById(Long compSeqNo, Long resourceSeqNo, String reslocationId) 
	{
		BookingResourceMasterPK bookingResourceMasterPK = new BookingResourceMasterPK();
		bookingResourceMasterPK.setReslocationId(reslocationId.trim());
		bookingResourceMasterPK.setCompanySeqNo(compSeqNo);
		bookingResourceMasterPK.setResourceSeqNo(resourceSeqNo);		
		Optional<BookingResourceMaster> resOptional = bookingResourceMasterRepo.findById(bookingResourceMasterPK);		
		BookingResourceMasterDTO lMaster = null;		
		
		if (resOptional.isPresent()) 
		{
		lMaster = getBookingResourceMasterDTO(resOptional.get());
		}
		return lMaster;

	}

	public void updBookingResourceMaster(BookingResourceMasterDTO lMaster) 
	{
		BookingResourceMasterPK bookingResourceMasterPK = new BookingResourceMasterPK();
		bookingResourceMasterPK.setReslocationId(lMaster.getReslocationId().trim());
		bookingResourceMasterPK.setCompanySeqNo(lMaster.getCompanySeqNo());
		bookingResourceMasterPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		BookingResourceMaster resourceMaster = null;
		
		if (bookingResourceMasterRepo.existsById(bookingResourceMasterPK)) 
		{	
		resourceMaster = bookingResourceMasterRepo.findById(bookingResourceMasterPK).get();
		bookingResourceMasterRepo.save(resourceMaster);			
		}
		return;
	}

	public void delBookingResourceMaster(Long compSeqNo, Long resourceSeqNo, String reslocationId) 
	{
		BookingResourceMasterPK bookingResourceMasterPK = new BookingResourceMasterPK();
		bookingResourceMasterPK.setReslocationId(reslocationId.trim());
		bookingResourceMasterPK.setCompanySeqNo(compSeqNo);
		bookingResourceMasterPK.setResourceSeqNo(resourceSeqNo);
		
		if (bookingResourceMasterRepo.existsById(bookingResourceMasterPK)) {
			bookingResourceMasterRepo.deleteById(bookingResourceMasterPK);
		}
		return;
	}

	public void delAllBookingResourceMasters() 
	{
		bookingResourceMasterRepo.deleteAll();
	}

	public void delSelectResources(ArrayList<Long> resourceSeqNos) 
	{
		if (resourceSeqNos != null) {
			bookingResourceMasterRepo.delSelectResources(resourceSeqNos);
		}
	}

	
	private ArrayList<BookingResourceMasterDTO> getBookingResourceMasterDTOs(ArrayList<BookingResourceMaster> lMasters) {
		BookingResourceMasterDTO lDTO = null;
		ArrayList<BookingResourceMasterDTO> lMasterDTOs = new ArrayList<BookingResourceMasterDTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getBookingResourceMasterDTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private BookingResourceMasterDTO getBookingResourceMasterDTO(BookingResourceMaster lMaster) 
	{		
		BookingResourceMasterDTO lDTO = new BookingResourceMasterDTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setUnitPrice(lMaster.getUnitPrice());
		lDTO.setUnitPriceSeqNo(lMaster.getUnitPriceSeqNo());
		lDTO.setDiscCode(lMaster.getDiscCode());
		lDTO.setTaxCode(lMaster.getTaxCode());
		lDTO.setQoh(lMaster.getQoh());
		lDTO.setSpeciFormatSeqNo(lMaster.getSpeciFormatSeqNo());				
		lDTO.setDescription(lMaster.getDescription());
		lDTO.setStatus(lMaster.getStatus());
		lDTO.setResourceId(lMaster.getResourceId());
		lDTO.setQtyCodeSeqNo(lMaster.getQtyCodeSeqNo());
		lDTO.setCompanySeqNo(lMaster.getId().getCompanySeqNo());
		lDTO.setReorderLevel(lMaster.getReorderLevel());
		lDTO.setReorderQty(lMaster.getReorderQty());
		lDTO.setMaxQty(lMaster.getMaxQty());
		lDTO.setResourceeCategorySeqNo(lMaster.getResourceeCategorySeqNo());
		lDTO.setDiscPer(lMaster.getDiscPer());
		lDTO.setDiscVal(lMaster.getDiscVal());
		lDTO.setTaxPer(lMaster.getTaxPer());
		lDTO.setResourceeCategorySeqNo(lMaster.getResourceeCategorySeqNo());
		return lDTO;
	}

	private BookingResourceMaster setBookingResourceMaster(BookingResourceMasterDTO lDTO) 
	{
		BookingResourceMaster lMaster = new BookingResourceMaster();				
		lMaster.setRemark(lDTO.getRemark());
		lMaster.setUnitPrice(lDTO.getUnitPrice());
		lMaster.setUnitPriceSeqNo(lDTO.getUnitPriceSeqNo());
		lMaster.setDiscCode(lDTO.getDiscCode());
		lMaster.setTaxCode(lDTO.getTaxCode());
		lMaster.setQoh(lDTO.getQoh());
		lMaster.setSpeciFormatSeqNo(lDTO.getSpeciFormatSeqNo());				
		lMaster.setDescription(lDTO.getDescription());
		lMaster.setStatus(lDTO.getStatus());
		lMaster.setResourceId(lDTO.getResourceId());
		lMaster.setQtyCodeSeqNo(lDTO.getQtyCodeSeqNo());		
		lMaster.setReorderLevel(lDTO.getReorderLevel());
		lMaster.setReorderQty(lDTO.getReorderQty());
		lMaster.setMaxQty(lDTO.getMaxQty());
		lMaster.setResourceeCategorySeqNo(lDTO.getResourceeCategorySeqNo());
		lMaster.setDiscPer(lDTO.getDiscPer());
		lMaster.setDiscVal(lDTO.getDiscVal());
		lMaster.setTaxPer(lDTO.getTaxPer());
		lMaster.setResourceeCategorySeqNo(lDTO.getResourceeCategorySeqNo());
		return lMaster;
	}
}