package de.halemba.shipmentservice.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.halemba.shipmentservice.db.DataPersistenceTemplate;
import de.halemba.shipmentservice.db.model.DhlState;
import de.halemba.shipmentservice.db.model.Shipment;
import de.halemba.shipmentservice.response.ResponseShipment;

@Service
public class ShipmentService {

	@Autowired
	DataPersistenceTemplate dbtemplate;
	
	public ResponseShipment importDHL(String identCode, Calendar shipmentDate, String iceEvent, String iceRic){
		
		String iceEventTextI;
		String iceRicTextI;
		String state = "OK";
		String errormsg = null;
		
		try {
		switch (iceEvent) {
		case "abc": iceEventTextI = "Daten avisiert";
					break;
		case "def": iceEventTextI = "Sendung in Verteilzentrum";
					break;
		case "ghi": iceEventTextI = "Sendung wurde zugestellt";
					break;
		default:    iceEventTextI = "Unbekannt";
		   	  		break;
		}
		
		switch(iceRic) {
		case "123":   iceRicTextI = "Elektronische Avisierung";
					  break;
		case "222":   iceRicTextI = "Verladung";
					  break;
		case "333":   iceRicTextI = "an Ablageort abgelegt";
					  break;
		default: iceRicTextI = "Unbekannt";
		     		  break;
		}
		
		dbtemplate.saveShipment(new Shipment(identCode, "0", shipmentDate, new DhlState(iceEvent, iceRic, iceEventTextI, iceRicTextI))); 
		} catch (Exception e) {
			state = "Error";
			errormsg = e.getMessage();
		}
		
		return new ResponseShipment(state, errormsg);
		
	}

	public ResponseShipment getCurrentShipmentState(String orderReference) {
		return dbtemplate.getShipment(orderReference);
	}

}


