package org.byteworks.calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.byteworks.test.api.ExperimentalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("math")
class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Tag("addition")
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

    @Tag("division")
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
            assertThrows(
                    ArithmeticException.class,
                    () -> calculator.divide(6, 0),
                    "6 / 0 should throw an error");
        }
    }

    @Tag("multiplication")
    @Nested
    class Multiplication {
        @Test
        @DisplayName("Multiplying two numbers")
        void multiply() {
            assertAll(
                    () -> assertEquals(6, calculator.multiply(3, 2), "3 * 2 should equal 6"),
                    () -> assertEquals(6, calculator.multiply(6, 1), "Identity property should work correctly"));
        }
    }

    @Nested
    class Trig {
        @ExperimentalTest
        @DisplayName("sin")
        void sin() {
            assertEquals(-0.98803162, calculator.sin(30.0), 0.1, "Should calculate sine correctly");
        }
    }
}
