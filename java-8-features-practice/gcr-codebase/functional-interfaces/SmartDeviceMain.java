package functional_interfaces;
public class SmartDeviceMain {
	interface SmartDevice{
		void turnOn();
		void turnOff();
	}
	
	static class Light implements SmartDevice{
		public void turnOn() {
			System.out.println("Light ON");
		}
		public void turnOff() {
			System.out.println("Light OFF");
		}
	}
	
	static class AC implements SmartDevice{
		public void turnOn() {
			System.out.println("Light ON");
		}
		public void turnOff() {
			System.out.println("Light OFF");
		}
	}
	
	static class TV implements SmartDevice{
		public void turnOn() {
			System.out.println("Light ON");
		}
		public void turnOff() {
			System.out.println("Light OFF");
		}
	}
	public static void main(String[] args) {
		SmartDevice d = new TV();
		d.turnOn();
		d.turnOff();
	}
}
