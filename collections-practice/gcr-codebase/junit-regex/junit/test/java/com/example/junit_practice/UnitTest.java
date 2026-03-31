package com.example.junit_practice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100.0);

        account.deposit(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100.0);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-20.0);
        });

        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(200.0);

        account.withdraw(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(100.0);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150.0);
        });

        assertEquals("Insufficient funds.", ex.getMessage());
    }
}
