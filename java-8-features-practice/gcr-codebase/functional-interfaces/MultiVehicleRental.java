package functional_interfaces;

public class MultiVehicleRental {
	interface MultiVehicle{
		void rent();
		void returnVehicle();
	}
	
	static class Cars implements MultiVehicle{
		public void rent() {
			System.out.println("Car Rented");
		}
		public void returnVehicle() {
			System.out.println("Car Returned");
		}
	}
	
	static class Bikes implements MultiVehicle{
		public void rent() {
			System.out.println("Bike Rented");
		}
		public void returnVehicle() {
			System.out.println("Bike Returned");
		}
	}
	
	static class Buses implements MultiVehicle{
		public void rent() {
			System.out.println("Bus Rented");
		}
		public void returnVehicle() {
			System.out.println("Bus Returned");
		}
	}
	public static void main(String[] args) {
		MultiVehicle m = new Cars();
		
		m.rent();
		m.returnVehicle();
	}
}
