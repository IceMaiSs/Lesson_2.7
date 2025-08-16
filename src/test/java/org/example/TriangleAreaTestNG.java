package org.example;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TriangleAreaTestNG {

    @Test
    public void testAreaWithIntegerValues() {
        assertEquals(TriangleArea.areaByBaseHeight(10, 5), 25.0);
    }

    @Test
    public void testAreaWithFractionalValues() {
        assertEquals(TriangleArea.areaByBaseHeight(3.5, 2.5), 4.375, 0.0001);
    }

    @DataProvider(name = "validData")
    public Object[][] provideValidData() {
        return new Object[][]{
                {1.0, 1.0, 0.5},
                {4.0, 6.0, 12.0},
                {2.5, 3.5, 4.375},
                {100, 50, 2500}
        };
    }

    @Test(dataProvider = "validData")
    public void testAreaWithValidData(double base, double height, double expected) {
        double actual = TriangleArea.areaByBaseHeight(base, height);
        assertEquals(actual, expected, 0.0001);
    }

    @DataProvider(name = "invalidData")
    public Object[][] provideInvalidData() {
        return new Object[][]{
                {0.0, 5.0},
                {5.0, 0.0},
                {-2.0, 3.0},
                {4.0, -1.0},
                {-1.0, -1.0},
        };
    }

    @Test(dataProvider = "invalidData",
            expectedExceptions = IllegalArgumentException.class)
    public void testInvalidInputs(double base, double height) {
        TriangleArea.areaByBaseHeight(base, height);
    }
}
