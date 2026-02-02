package week3.aeroVigil;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) throws InvalidFlightException {
		String input = "FL-2345:IndiGo:250:120000";
		String[] flightDetails = input.split(":");
		String flightNumber = flightDetails[0], fightName = flightDetails[1];
		int passengerCount = Integer.parseInt(flightDetails[2]);
		float currentFuelLevel = Float.parseFloat(flightDetails[3]);
		try {
			FlightUtil ft = new FlightUtil();
			ft.validateFlightNumber(flightNumber);
			ft.validateFlightName(fightName);
			ft.validatePassengerCount(passengerCount, fightName);
			System.out.println("Fuel required to fill the tank: " + ft.calculateFuelToFillTank(fightName, currentFuelLevel) + " litres.");

		} catch (InvalidFlightException e) {
			System.err.println(e.getMessage());
		}
	}
}
