package com.example.junit_practice;
public class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null) return false;
        
        String pattern = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password.matches(pattern);
    }
}