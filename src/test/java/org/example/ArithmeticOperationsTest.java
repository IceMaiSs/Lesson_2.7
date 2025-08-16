package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, 1, 0",
            "2147483647, 0, 2147483647",
            "-2147483648, 0, -2147483648"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @Test
    void testAddOverflow() {
        assertEquals(-2147483648, ArithmeticOperations.add(2147483647, 1));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "0, 0, 0",
            "1, -1, 2",
            "2147483647, 2147483647, 0",
            "-2147483648, -2147483648, 0"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @Test
    void testSubtractUnderflow() {
        assertEquals(2147483647, ArithmeticOperations.subtract(-2147483648, 1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "0, 5, 0",
            "-2, 3, -6",
            "1, 1, 1",
            "12345, 6789, 83810205"
    })
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.multiply(a, b));
    }

    @Test
    void testMultiplyOverflow() {
        assertEquals(-2, ArithmeticOperations.multiply(2147483647, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2.0",
            "1, 2, 0.5",
            "10, 3, 3.3333333333333335",
            "-9, 3, -3.0",
            "0, 5, 0.0"
    })
    void testDivide(int a, int b, double expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b), 0.000000000000001);
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> ArithmeticOperations.divide(1, 0)
        );
        assertEquals("Division by zero", exception.getMessage());
    }
}