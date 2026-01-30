package week2.future_logistics;

public class TimberTransport extends GoodsTransport {
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, String timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = timberLength;
		this.timberRadius = timberRadius;
		this.timberType = timberType;
		this.timberPrice = timberPrice;
	}

	public float getTimberLength() {
		return timberLength;
	}

	public float getTimberRadius() {
		return timberRadius;
	}

	public String getTimberType() {
		return timberType;
	}

	public float getTimberPrice() {
		return timberPrice;
	}

	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}

	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}

	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}

	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}

	public String vehicleSelection() {
		float area = (float) (2 * 3.147 * timberRadius * timberLength);
		if (area > 400)
			return "Monster Lorry";
		else if (area > 249)
			return "Lorry";
		return "Truck";
	}

	public float calculateTotalCharge() {
		float volume = 3.147f * timberRadius * timberRadius * timberLength;
		float price = volume * timberPrice * ((timberType.equals("Premium")) ? 0.25f : 0.15f);
		String vehicle = vehicleSelection();
		float vehiclePrice = vehicle.equals("Truck") ? 1000 : vehicle.equals("Lorry") ? 1700 : 3000;
		float tax = price * 0.3f;
		float discount = price * (transportRating == 5 ? 0.2f : transportRating > 2 ? 0.1f : 0);
		return (price + vehiclePrice + tax) - discount;
	}

	@Override
	public String toString() {
		return super.toString() + "Type of the timber : " + timberType + '\n' + "Timber price per kilo : " + timberPrice
				+ '\n' + "Vehicle for transport : " + vehicleSelection() + '\n' + "Total charge : "
				+ calculateTotalCharge();
	}
}
