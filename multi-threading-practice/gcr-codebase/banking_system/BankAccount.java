package multi_threading.banking_system;

public class BankAccount {
	private int balance = 10000;
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(String customerName, int amount) {
		System.out.println("[" + Thread.currentThread().getName() 
                + "] Attempting to withdraw " + amount);
		if(balance >= amount) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance -= amount;
			
			 System.out.println("Transaction successful: " 
	                    + customerName 
	                    + ", Amount: " + amount 
	                    + ", Balance: " + balance 
	                    + ", Time: " + java.time.LocalTime.now());
		}else {
			System.out.println("Transaction failed (Insufficient Balance): " 
                    + customerName 
                    + ", Amount: " + amount 
                    + ", Balance: " + balance);
		}
	}
}
