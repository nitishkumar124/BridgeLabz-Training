package week2.future_logistics;

import java.util.*;

public class BrickTransport extends GoodsTransport {

	private float brickSize = 0;
	private int brickQuantity = 0;
	private float brickPrice = 0;

	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		this.brickSize = brickSize;
		this.brickQuantity = brickQuantity;
		this.brickPrice = brickPrice;
	}

	public float getBrickSize() {
		return brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}

	public String vehicleSelection() {
		if (brickQuantity > 500)
			return "MonsterLorry";
		else if (brickQuantity > 299)
			return "Lorry";

		return "Truck";
	}

	public float calculateTotalCharge() {
		float price = brickPrice * brickQuantity;

		String vehicle = vehicleSelection();
		float vehiclePrice = (vehicle == "Truck") ? 1000 : vehicle == "Lorry" ? 1700 : 3000;

		float tax = price * 0.3f;

		float discount = price * ((transportRating == 5) ? 0.2f : (transportRating > 2) ? 0.1f : 0);

		return ((price) + vehiclePrice + tax) - discount;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Quantity of bricks : " + brickQuantity + '\n' + "Brick price : " + brickPrice
				+ '\n' + "Vehicle for transport : " + vehicleSelection() + '\n' + "Total charge : "
				+ calculateTotalCharge();
	}
}
