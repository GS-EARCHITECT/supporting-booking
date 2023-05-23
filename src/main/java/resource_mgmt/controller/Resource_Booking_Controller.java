package resource_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_mgmt.services.I_ResourceBooking_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceBooking")
public class Resource_Booking_Controller 
{
	private static final Logger logger = LoggerFactory.getLogger(Resource_Booking_Controller.class);

	@Autowired
	private I_ResourceBooking_Service resourceBookingMgmtServ;
	
	@PostMapping("/assetFCFS/{companySeqNo}/{assetSeqNo}/{assetLocationId}")
	public ResponseEntity<Long> newAssetBookingFCFS(@PathVariable Long companySeqNo, @PathVariable Long assetSeqNo, @PathVariable String assetLocationId)	
	{
		Long bookFlag = resourceBookingMgmtServ.resource_Alloc_Asset(companySeqNo, assetSeqNo, assetLocationId, null, null);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(bookFlag, httpHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/assetTimeBasis/{companySeqNo}/{assetSeqNo}/{assetLocationId}/{frDtTm}/{toDtTm}")
	public ResponseEntity<Long> newAssetBookingTimeBasis(@PathVariable Long companySeqNo, @PathVariable Long assetSeqNo, @PathVariable String assetLocationId, @PathVariable String frDtTm, @PathVariable String toDtTm)	
	{
		Long bookFlag = resourceBookingMgmtServ.resource_Alloc_Asset(companySeqNo, assetSeqNo, assetLocationId, frDtTm, toDtTm);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(bookFlag, httpHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping("/resFCFS/{companySeqNo}/{resSeqNo}/{resLocationId}/{qtySeqNo}/{qty}")	
	public ResponseEntity<Long> newResourceBookingTimeBasis(@PathVariable Long companySeqNo, @PathVariable Long resSeqNo, @PathVariable String resLocationId, @PathVariable Long qtySeqNo, @PathVariable Float qty)	
	{
		Long bookFlag = resourceBookingMgmtServ.resource_Alloc_Cate(companySeqNo, resSeqNo, resLocationId, null, null, qtySeqNo, qty);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(bookFlag, httpHeaders, HttpStatus.CREATED);
	}

	
	@PostMapping("/resTimeBasis/{companySeqNo}/{resSeqNo}/{resLocationId}/{frDTTm}/{toDTTm}/{qtySeqNo}/{qty}")	
	public ResponseEntity<Long> newResourceBookingTimeBasis(@PathVariable Long companySeqNo, @PathVariable Long resSeqNo, @PathVariable String resLocationId, @PathVariable String frDtTm, @PathVariable String toDtTm, @PathVariable Long qtySeqNo, @PathVariable Float qty)	
	{
		Long bookFlag = resourceBookingMgmtServ.resource_Alloc_Cate(companySeqNo, resSeqNo, resLocationId, frDtTm, toDtTm, qtySeqNo, qty);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(bookFlag, httpHeaders, HttpStatus.CREATED);
	}
	
	}