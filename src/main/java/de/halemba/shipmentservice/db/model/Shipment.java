package de.halemba.shipmentservice.db.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shipment {

	private Calendar shipmentdate;
	private String orderReference;
	private String shipmentIdentCode;
	private ICarrierState carrierState;
	
	List<ICarrierState> history = new ArrayList<>();
	
	public Shipment(String shipmentIdentCode, String orderReference, Calendar shipmentdate, ICarrierState carrierState) {
		super();
		this.shipmentIdentCode = shipmentIdentCode;
		this.orderReference = orderReference;
		this.shipmentdate = shipmentdate;
		this.carrierState = carrierState;
	}
	
	public void setOrderReference(String reference) {
		this.orderReference = reference;
	}
	
	public String getOrderReference() {
		return this.orderReference;
	}
	
	public ICarrierState getCarrierState() {
		return this.carrierState;
	}
}
