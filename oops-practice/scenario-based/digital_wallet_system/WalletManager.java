package week2.digital_wallet_system;
import java.util.*;

class WalletManager {
    private Map<String, Wallet> userWallets = new HashMap<>();

    // CRUD: Wallet Creation
    public void createWallet(String username) {
        userWallets.put(username, new Wallet());
    }

    public Wallet getWallet(String username) {
        return userWallets.get(username);
    }

    // CRUD: Transaction Tracking
    public void printHistory(String username) {
        System.out.println("\n--- History for " + username + " ---");
        for (Transaction t : getWallet(username).getHistory()) {
            System.out.println(t);
        }
        System.out.println("Current Balance: $" + getWallet(username).getBalance());
    }
}