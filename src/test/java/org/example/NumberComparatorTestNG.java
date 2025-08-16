package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    @Test
    public void testFirstGreaterThanSecond() {
        assertEquals(NumberComparator.compare(5, 3), 1);
    }

    @Test
    public void testFirstLessThanSecond() {
        assertEquals(NumberComparator.compare(3, 5), -1);
    }

    @Test
    public void testNumbersEqual() {
        assertEquals(NumberComparator.compare(4, 4), 0);
    }

    @DataProvider(name = "comparisonData")
    public Object[][] provideComparisonData() {
        return new Object[][]{
                {10, 5, 1},
                {5, 10, -1},
                {0, 0, 0},
                {-3, -1, -1},
                {-2, -5, 1},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 1},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1}
        };
    }

    @Test(dataProvider = "comparisonData")
    public void testCompareWithDataProvider(int a, int b, int expected) {
        assertEquals(NumberComparator.compare(a, b), expected);
    }
    @Test
    public void testCompareWithZero() {
        assertEquals(NumberComparator.compare(0, 5), -1);
        assertEquals(NumberComparator.compare(5, 0), 1);
        assertEquals(NumberComparator.compare(0, 0), 0);
        assertEquals(NumberComparator.compare(0, -5), 1);
        assertEquals(NumberComparator.compare(-5, 0), -1);
    }
}