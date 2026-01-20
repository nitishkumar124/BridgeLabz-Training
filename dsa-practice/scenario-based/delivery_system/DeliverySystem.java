package week3.delivery_system;

import java.util.Objects;

public class DeliverySystem {
	public static void main(String[] args) {

		ParcelTracker myParcel = new ParcelTracker("PRCL-9901", "Packed");

		myParcel.addFinalStage("Shipped");
		myParcel.addFinalStage("In Transit");
		myParcel.addFinalStage("Delivered");

		myParcel.addCheckpointAfter("In Transit", "Customs Clearance");
		myParcel.addCheckpointAfter("Customs Clearance", "Out for Delivery");

		myParcel.trackParcel();

		ParcelTracker lostParcel = new ParcelTracker("LOST-404", "Packed");
		lostParcel.addFinalStage("Shipped");

		lostParcel.trackParcel();
	}
}