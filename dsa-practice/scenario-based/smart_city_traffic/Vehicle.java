package week3.smart_city_traffic;

public class Vehicle {
	String licensePlate;
	Vehicle next; 

	public Vehicle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "[" + licensePlate + "]";
	}
}