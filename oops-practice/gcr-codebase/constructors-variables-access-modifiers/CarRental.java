package level1;

import java.util.*;

public class CarRental {
	String customerName;
	String carModel;
	int rentalDay;

	public CarRental(String customerName, String carModel, int rentalDay) {
		this.customerName = customerName;
		this.carModel = carModel;
		this.rentalDay = rentalDay;
	}

	void totalCost() {
		int cost = rentalDay * 1500;
		System.out.println("total rental cost : $" + cost);
	}

	public static void main(String[] args) {

		CarRental car = new CarRental("Aryansh", "WagonR", 5);
		car.totalCost();
	}
}
