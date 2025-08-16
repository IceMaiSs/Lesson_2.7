import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleAreaTest {

    @ParameterizedTest
    @MethodSource("validInputProvider")
    void testAreaByBaseHeightWithValidInput(double base, double height, double expectedArea) {
        assertEquals(expectedArea, TriangleArea.areaByBaseHeight(base, height), 0.0001);
    }

    private static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(1.0, 1.0, 0.5),
                Arguments.of(2.0, 3.0, 3.0),
                Arguments.of(5.0, 4.0, 10.0),
                Arguments.of(10.5, 7.2, 37.8),
                Arguments.of(0.1, 0.1, 0.005)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -0.0001})
    void testAreaByBaseHeightWithZeroOrNegativeBase(double invalidBase) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.areaByBaseHeight(invalidBase, 1.0)
        );
        assertEquals("Основание и высота должны быть положительными", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -0.0001})
    void testAreaByBaseHeightWithZeroOrNegativeHeight(double invalidHeight) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.areaByBaseHeight(1.0, invalidHeight)
        );
        assertEquals("Основание и высота должны быть положительными", exception.getMessage());
    }

    @Test
    void testAreaByBaseHeightWithBothNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.areaByBaseHeight(-1.0, -2.0)
        );
        assertEquals("Основание и высота должны быть положительными", exception.getMessage());
    }
}
