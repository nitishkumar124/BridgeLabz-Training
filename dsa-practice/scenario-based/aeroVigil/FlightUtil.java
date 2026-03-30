package week3.aeroVigil;

public class FlightUtil {

	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
		if (!flightNumber.matches("^FL-[0-9]{4}$")) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid.");
		}
		return true;
	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {
		if (!flightName.matches("SpiceJet|Vistara|IndiGo|Air Arabia")) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid.");
		}
		return true;
	}

	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {

		boolean c1 = passengerCount > 0, c2 = true;
		switch (flightName) {
		case "SpiceJet":
			c2 = passengerCount < 397;
			break;
		case "Vistara":
			c2 = passengerCount < 616;
			break;
		case "IndiGo":
			c2 = passengerCount < 231;
			break;
		case "Air Arabia":
			c2 = passengerCount < 131;
			break;
		}

		
		if (!c1 || !c2)
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);

		return true;

	}

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
		double fuelRequired = 0;

		switch (flightName) {
		case "SpiceJet":
			fuelRequired = 200_000 - currentFuelLevel;
			break;
		case "Vistara":
			fuelRequired = 300_000 - currentFuelLevel;
			break;
		case "IndiGo":
			fuelRequired = 250_000 - currentFuelLevel;
			break;
		case "Air Arabia":
			fuelRequired = 150_000 - currentFuelLevel;
			break;
		}

		if (currentFuelLevel < 0 || fuelRequired < 0)
			throw new InvalidFlightException("Invalid fuel level for " + flightName);

		return fuelRequired;
	}
}
