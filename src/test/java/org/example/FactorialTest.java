package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorialIterative(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.factorialIterative(1));
    }

    @Test
    void testFactorialOfSmallNumber() {
        assertEquals(2, Factorial.factorialIterative(2));
        assertEquals(6, Factorial.factorialIterative(3));
        assertEquals(24, Factorial.factorialIterative(4));
        assertEquals(120, Factorial.factorialIterative(5));
    }

    @Test
    void testFactorialOfMediumNumber() {
        assertEquals(720, Factorial.factorialIterative(6));
        assertEquals(5040, Factorial.factorialIterative(7));
        assertEquals(40320, Factorial.factorialIterative(8));
    }

    @Test
    void testNegativeInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorialIterative(-1));
        assertEquals("Факториал отрицательного числа не определен", exception.getMessage());
    }
}