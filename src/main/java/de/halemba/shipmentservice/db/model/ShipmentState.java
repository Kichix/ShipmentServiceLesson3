package de.halemba.shipmentservice.db.model;

import java.util.Calendar;

public class ShipmentState {
	Calendar timestamp;
	ICarrierState carrierState;

	public ShipmentState(Calendar timestamp, ICarrierState carrierState) {
		super();
		this.timestamp = timestamp;
		this.carrierState = carrierState;
	}

}
