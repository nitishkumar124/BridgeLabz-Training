package week2.digital_wallet_system;
public class DigitalWalletSystem {
    public static void main(String[] args) {
        WalletManager manager = new WalletManager();

        // 1. User Creation
        manager.createWallet("Alice");
        manager.createWallet("Bob");
        Wallet aliceWallet = manager.getWallet("Alice");
        Wallet bobWallet = manager.getWallet("Bob");

        // 2. Add Money
        aliceWallet.deposit(500.0);

        try {
            // 3. Fund Transfer (Polymorphism in action)
            TransferService walletToWallet = new WalletTransfer(bobWallet);
            walletToWallet.transfer(aliceWallet, 200.0);

            // 4. Bank Transfer
            TransferService walletToBank = new BankTransfer("CHASE-9988");
            walletToBank.transfer(aliceWallet, 100.0);

            // 5. Trigger Exception
            System.out.println("Attempting to transfer more than balance...");
            walletToWallet.transfer(aliceWallet, 1000.0);

        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        // 6. View History
        manager.printHistory("Alice");
        manager.printHistory("Bob");
    }
}