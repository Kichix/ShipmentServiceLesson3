package de.halemba.shipmentservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.halemba.shipmentservice.response.ResponseShipment;
import de.halemba.shipmentservice.service.ShipmentService;

@RestController
@RequestMapping("/")
public class ShipmentServiceController {

	@Autowired
	ShipmentService shipmentservice;

	@RequestMapping(value= "/ImportDhl")
	public ResponseShipment importDHL(
			@RequestParam(value = "identCode", required = true) String identCode,
			@RequestParam(value = "shipmentDate", required = true) String shipmentDate,
			@RequestParam(value = "iceEvent", required = true) String iceEvent,
			@RequestParam(value = "iceRic", required = true) String iceRic
			) {
		
		Calendar cal = Calendar.getInstance();
		
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.GERMAN);
				try {
					cal.setTime(sdf.parse(shipmentDate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		
        return shipmentservice.importDHL(identCode, cal, iceEvent, iceRic); 
		}
	
}
