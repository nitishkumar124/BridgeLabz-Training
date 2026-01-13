package week2.digital_wallet_system;
interface TransferService {
    void transfer(Wallet sender, double amount) throws InsufficientBalanceException;
}

