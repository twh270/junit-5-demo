package org.byteworks.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Nested
    class Addition {

        @Test
        @DisplayName("1 + 1 = 2")
        void addsTwoNumbers() {
            assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        }

        @ParameterizedTest(name = "{0} + {1} = {2}")
        // @formatter:off
        @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101" })
        // @formatter:on
        void add(int first, int second, int expectedResult) {
            assertEquals(expectedResult, calculator.add(first, second),
                    () -> first + " + " + second + " should equal " + expectedResult);
        }
    }

    @Nested
    class Division {
        @Test
        @DisplayName("6 / 2 = 3")
        void dividesTwoNumbers() {
            assertEquals(3, calculator.divide(6, 2), "6 / 2 should equal 3");
        }

        @Test
        @DisplayName("6 / 0 = error")
        void dividesByZero() {
            Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0),
                    "6 / 0 should throw an error");
        }
    }
}
