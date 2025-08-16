package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @ParameterizedTest
    @CsvSource({
            "5, 3, 1",
            "2, 4, -1",
            "7, 7, 0",
            "0, 0, 0",
            "-5, -3, -1",
            "-2, -4, 1",
            "2147483647, 1, 1",
            "-2147483648, -1, -1"
    })
    void testCompare(int a, int b, int expected) {
        assertEquals(expected, NumberComparator.compare(a, b));
    }

    @Test
    void testBoundaryValues() {
        assertEquals(1, NumberComparator.compare(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals(-1, NumberComparator.compare(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(0, NumberComparator.compare(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0, NumberComparator.compare(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
