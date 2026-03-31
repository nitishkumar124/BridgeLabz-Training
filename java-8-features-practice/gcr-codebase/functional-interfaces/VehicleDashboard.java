package functional_interfaces;

public class VehicleDashboard {
	interface Dashboard{
		void showSpeed();
		
		default void showBattery() {
			System.out.println("No battery info");
		}
	}
	static class ElectricCar implements Dashboard{
		public void showSpeed() {
			System.out.println("Speed 80 km/h");
		}
		public void showBattery() {
			System.out.println("Battery 75%");
		}
	}
	public static void main(String[] args) {
		Dashboard d = new ElectricCar();
		d.showSpeed();
		d.showBattery();
	}
}
