package resource_mgmt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_mgmt.model.dto.BookingResourceMasterDTO;
import resource_mgmt.services.I_BookingResourceMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/bookingResourceManagement")
public class Booking_Resource_Master_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(BookingResourceMaster_Controller.class);

	@Autowired
	private I_BookingResourceMasterService resourceBookingMasterServ;

	@PostMapping("/new")
	public ResponseEntity<BookingResourceMasterDTO> newresource(@RequestBody BookingResourceMasterDTO resourceDTO) {
		BookingResourceMasterDTO resourceDTO2 = resourceBookingMasterServ.newBookingResourceMaster(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<BookingResourceMasterDTO>> getAllBookingResourceMasters() {
		ArrayList<BookingResourceMasterDTO> resourceDTOs = resourceBookingMasterServ.getAllBookingResourceMasters();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<BookingResourceMasterDTO>> getSelectBookingResourceMasters(
			@RequestBody ArrayList<Long> resourceSeqNos) {
		ArrayList<BookingResourceMasterDTO> resourceDTOs = resourceBookingMasterServ.getSelectResources(resourceSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesByCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<BookingResourceMasterDTO>> getSelectBookingResourceMastersByCategories(
			@RequestBody ArrayList<BigDecimal> resourceCateSeqNos) {
		ArrayList<BookingResourceMasterDTO> resourceDTOs = resourceBookingMasterServ
				.getSelectResourcesByCategories(resourceCateSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesByCompanies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<BookingResourceMasterDTO>> getSelectBookingResourceMastersByCompanies(
			@RequestBody ArrayList<Long> cos) {
		ArrayList<BookingResourceMasterDTO> resourceDTOs = resourceBookingMasterServ.getSelectResourcesByCompanies(cos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesByPriceRange/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<BookingResourceMasterDTO>> getSelectBookingResourceMastersByPriceRange(
			@PathVariable Float fr, @PathVariable Float to) {
		ArrayList<BookingResourceMasterDTO> resourceDTOs = resourceBookingMasterServ.getSelectResourcesByPriceRange(fr,
				to);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getById/{compSeqNo}/{resourceSeqNo}/{reslocationId}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BookingResourceMasterDTO> getBookingResourceMasterById(@PathVariable Long compSeqNo,
			@PathVariable Long resourceSeqNo, @PathVariable String reslocationId) {
		BookingResourceMasterDTO resourceAccNoDTOs = resourceBookingMasterServ.getBookingResourceMasterById(compSeqNo,
				resourceSeqNo, reslocationId);
		return new ResponseEntity<>(resourceAccNoDTOs, HttpStatus.OK);
	}

	@PutMapping("/updresource")
	public void updateresource(@RequestBody BookingResourceMasterDTO resourceDTO) {
		resourceBookingMasterServ.updBookingResourceMaster(resourceDTO);
		return;
	}

	@DeleteMapping("/delresource/{compSeqNo}/{resourceSeqNo}/{reslocationId}")
	public void deleteresource(@PathVariable Long compSeqNo, @PathVariable Long resourceSeqNo,
			@PathVariable String reslocationId) {
		resourceBookingMasterServ.delBookingResourceMaster(compSeqNo, resourceSeqNo, reslocationId);
	}

	@DeleteMapping("/delSelectresource")
	public void deleteSelectresource(@RequestBody ArrayList<Long> resourceSeqNoList) {
		resourceBookingMasterServ.delSelectResources(resourceSeqNoList);
		;
		return;
	}

	@DeleteMapping("/delAllresource")
	public void deleteAllresources() {
		resourceBookingMasterServ.delAllBookingResourceMasters();
		;
		return;
	}
}