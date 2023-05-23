package resource_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import resource_mgmt.model.dto.BookingResourceMasterDTO;

public interface I_BookingResourceMasterService
{
    abstract public BookingResourceMasterDTO newBookingResourceMaster(BookingResourceMasterDTO lMaster);
    abstract public ArrayList<BookingResourceMasterDTO> getAllBookingResourceMasters();
    abstract public ArrayList<BookingResourceMasterDTO> getSelectResources(ArrayList<Long> ids);
    abstract public ArrayList<BookingResourceMasterDTO> getSelectResourcesByPriceRange(Float fr, Float to);
    abstract public ArrayList<BookingResourceMasterDTO> getSelectResourcesByCategories(ArrayList<BigDecimal> ids);
    abstract public ArrayList<BookingResourceMasterDTO> getSelectResourcesByCompanies(ArrayList<Long> ids);
    abstract public BookingResourceMasterDTO getBookingResourceMasterById(Long compSeqNo, Long resourceSeqNo, String reslocationId);
    abstract public void updBookingResourceMaster(BookingResourceMasterDTO lMaster);
    abstract public void delBookingResourceMaster(Long compSeqNo, Long resourceSeqNo, String reslocationId);
    abstract public void delAllBookingResourceMasters();
    abstract public void delSelectResources(ArrayList<Long> resourceSeqNos);
}