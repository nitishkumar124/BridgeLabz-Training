package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(4, calc.divide(20, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> calc.divide(10, 0));
    }    
}