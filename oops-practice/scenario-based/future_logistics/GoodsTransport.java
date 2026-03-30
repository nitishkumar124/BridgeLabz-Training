package week2.future_logistics;

import javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction;

public abstract class GoodsTransport {

	protected String transportId;
	protected String transportDate;
	protected int transportRating;

	public GoodsTransport(String transportId, String transportDate, int transportRating) {
		this.transportId = transportId;
		this.transportDate = transportDate;
		this.transportRating = transportRating;
	}

	public String getTransportId() {
		return transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}

	abstract public String vehicleSelection();

	abstract public float calculateTotalCharge();

	@Override
	public String toString() {
		return "Transporter id : " + transportId + '\n' + "Date of transport : " + transportDate + '\n'
				+ "Rating of the transport : " + transportRating + '\n';
	}

}
