package functional_interfaces;

public class PaymentGateway {
	interface PaymentProcessor{
		void pay(double amount);
		
		default void refund(double amount) {
			System.out.println("Refunded Rs. " + amount);
		}
	}
	
	static class GooglePay implements PaymentProcessor{
		public void pay(double amount) {
			System.out.println("Paid Rs. " + amount);
		}
	}
	public static void main(String[] args) {
		PaymentProcessor p = new GooglePay();
		p.pay(200);
		p.refund(100);
	}
}
