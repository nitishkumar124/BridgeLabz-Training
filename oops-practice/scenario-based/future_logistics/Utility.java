package week2.future_logistics;

public class Utility {
	public GoodsTransport parseDetails(String input) {
		String[] data = input.split(":");

		String transportId = data[0], transportDate = data[1];
		int transportRating = Integer.parseInt(data[2]);

		if (data[3].equals("BrickTransport")) {
			return new BrickTransport(transportId, transportDate, transportRating, Float.parseFloat(data[4]),
					Integer.parseInt(data[5]), Float.parseFloat(data[6]));
		}
		return new TimberTransport(transportId, transportDate, transportRating, Float.parseFloat(data[4]),
				Float.parseFloat(data[5]), data[6], Float.parseFloat(data[7]));
	}

	public boolean validateTransportId(String transportId) {
		if (transportId.matches("RTS[0-9]{3}[A-Z]"))
			return true;

		System.out.println("Transport id " + transportId + " is invalid.\n" + "Please provide a valid record");
		return false;
	}

	public String findObjectType(GoodsTransport goodsTransport) {
		if (goodsTransport instanceof BrickTransport) {
			return "Brick Transport";
		}
		return "Timber Transport";
	}

}
