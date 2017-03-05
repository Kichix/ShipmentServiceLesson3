package de.halemba.shipmentservice.db.model;

public class HvsState implements ICarrierState {

	String stateCode;
	String stateCodeText;

	public HvsState(String stateCode, String stateCodeText) {
		super();
		this.stateCode = stateCode;
		this.stateCodeText = stateCodeText;
	}

	@Override
	public String getStatusMessage() {
		return stateCodeText;
	}

}
