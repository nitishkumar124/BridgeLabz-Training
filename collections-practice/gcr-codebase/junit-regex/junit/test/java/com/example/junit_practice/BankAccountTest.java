package com.example.junit_practice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0);
    }

    @Test
    void testDepositIncreasesBalance() {
        account.deposit(50.0);
        // Using delta for double comparison to handle precision
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawDecreasesBalance() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawInsufficientFundsThrowsException() {
        // Attempting to withdraw $200 from a $100 account
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });

        assertEquals("Insufficient funds", exception.getMessage());
    }
}