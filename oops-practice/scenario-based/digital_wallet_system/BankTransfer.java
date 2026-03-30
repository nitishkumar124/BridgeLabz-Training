package week2.digital_wallet_system;
class BankTransfer implements TransferService {
    private String accountNumber;
    public BankTransfer(String accountNumber) { this.accountNumber = accountNumber; }

    public void transfer(Wallet sender, double amount) throws InsufficientBalanceException {
        sender.withdraw(amount); // Deduct from wallet
        // Logic for external bank API call would go here
        System.out.println("Transfer successful: Wallet to Bank Account " + accountNumber);
    }
}