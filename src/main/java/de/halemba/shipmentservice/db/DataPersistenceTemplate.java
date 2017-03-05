package de.halemba.shipmentservice.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import de.halemba.shipmentservice.db.model.Shipment;
import de.halemba.shipmentservice.response.ResponseShipment;

@Configuration
public class DataPersistenceTemplate {
	
	Map<String, Shipment> shipments;
	int orderreference;
	
	public DataPersistenceTemplate() {
		initialize();
	}
	
	private void initialize() {
		orderreference = 0;
		
		shipments = new HashMap<>();
	}
	
	public void saveShipment(Shipment shipment) {
		
		this.orderreference += 1;
		
		shipment.setOrderReference(Integer.toString(this.orderreference));
		shipments.put(Integer.toString(orderreference), shipment);
		
	}
	
	public ResponseShipment getShipment(String orderReference) {
		
		Shipment shipment = shipments.get(orderReference);
		
		return new ResponseShipment(shipment.getCarrierState().getStatusMessage(), "OK");
	}
}

