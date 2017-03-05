package de.halemba.shipmentservice.db.model;

public class DhlState implements ICarrierState {

	String iceEvent;
	String iceRic;
	String iceEventText;
	String iceRicText;

	public DhlState(String iceEvent, String iceRic, String iceEventText, String iceRicText) {
		super();
		this.iceEvent = iceEvent;
		this.iceRic = iceRic;
		this.iceEventText = iceEventText;
		this.iceRicText = iceRicText;
	}

	@Override
	public String getStatusMessage() {
		return this.iceEventText + " :: " + iceRicText;
	}

}
