package week2.digital_wallet_system;
class WalletTransfer implements TransferService {
    private Wallet receiver;
    public WalletTransfer(Wallet receiver) { this.receiver = receiver; }

    public void transfer(Wallet sender, double amount) throws InsufficientBalanceException {
        sender.withdraw(amount);
        receiver.deposit(amount);
        System.out.println("Transfer successful: Wallet to Wallet.");
    }
}