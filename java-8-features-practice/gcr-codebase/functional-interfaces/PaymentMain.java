package functional_interfaces;
public class PaymentMain {
	interface Payment{
		void pay(double amount);
	}
	
	static class UPI implements Payment{
		public void pay(double amount) {
			System.out.println("Paid Rs. " + amount + " via UPI");
		}
	}
	
	static class CreditCard implements Payment{
		public void pay(double amount) {
			System.out.println("Paid Rs. " + amount + " via UPI");
		}
	}
	
	static class Wallet implements Payment{
		public void pay(double amount) {
			System.out.println("Paid Rs. " + amount + " via UPI");
		}
	}
	public static void main(String[] args) {
		Payment p = new UPI();
		p.pay(500);
	}
}
