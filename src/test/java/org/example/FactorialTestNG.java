package org.example;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class FactorialTestNG {

    @Test
    public void factorialOfZeroShouldBe1() {
        assertEquals(Factorial.factorialIterative(0), 1L);
    }

    @Test
    public void factorialOfOneShouldBe1() {
        assertEquals(Factorial.factorialIterative(1), 1L);
    }

    @Test
    public void factorialOfFiveShouldBe120() {
        assertEquals(Factorial.factorialIterative(5), 120L);
    }

    @DataProvider(name = "validInputs")
    public Object[][] validInputs() {
        return new Object[][]{
                {0, 1L},
                {1, 1L},
                {2, 2L},
                {3, 6L},
                {5, 120L},
                {10, 3628800L},
                {20, 2432902008176640000L}
        };
    }

    @Test(dataProvider = "validInputs")
    public void testFactorialWithDataProvider(int input, long expected) {
        assertEquals(Factorial.factorialIterative(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeInputShouldThrowException() {
        Factorial.factorialIterative(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void largeNegativeInputShouldThrowException() {
        Factorial.factorialIterative(-100);
    }
}