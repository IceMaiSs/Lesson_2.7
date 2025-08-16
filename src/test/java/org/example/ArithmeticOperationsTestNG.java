package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {
    @Test
    public void testAddPositiveNumbers() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(ArithmeticOperations.add(-2, -3), -5);
    }

    @Test
    public void testAddZero() {
        assertEquals(ArithmeticOperations.add(0, 5), 5);
        assertEquals(ArithmeticOperations.add(5, 0), 5);
    }

    // ===== Тесты для вычитания =====
    @Test
    public void testSubtractPositiveNumbers() {
        assertEquals(ArithmeticOperations.subtract(5, 3), 2);
    }

    @Test
    public void testSubtractNegativeNumbers() {
        assertEquals(ArithmeticOperations.subtract(-2, -3), 1);
    }

    @Test
    public void testSubtractZero() {
        assertEquals(ArithmeticOperations.subtract(5, 0), 5);
    }

    // ===== Тесты для умножения =====
    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(ArithmeticOperations.multiply(-2, -3), 6);
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(ArithmeticOperations.multiply(5, 0), 0);
    }

    // ===== Тесты для деления =====
    @Test
    public void testDividePositiveNumbers() {
        assertEquals(ArithmeticOperations.divide(6, 3), 2.0);
    }

    @Test
    public void testDivideNegativeNumbers() {
        assertEquals(ArithmeticOperations.divide(-6, -3), 2.0);
    }

    @Test
    public void testDivideFractionalResult() {
        assertEquals(ArithmeticOperations.divide(5, 2), 2.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticOperations.divide(5, 0);
    }

    @Test
    public void testDivideByZeroExceptionMessage() {
        try {
            ArithmeticOperations.divide(5, 0);
            fail("Ожидалось исключение ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "Division by zero");
        }
    }
}