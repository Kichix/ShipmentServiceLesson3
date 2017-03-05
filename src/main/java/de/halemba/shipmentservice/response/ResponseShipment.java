package de.halemba.shipmentservice.response;

import de.halemba.shipmentservice.db.model.Shipment;

public class ResponseShipment {

	String state;
	String errormsg;
	
	public ResponseShipment(String state, String errormessage) {
		this.state = state;
		this.errormsg = errormessage;
	} 
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setErrormsg(String msg) {
		this.errormsg = msg;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String geterrormsg(){
		return this.errormsg;
	}
}
