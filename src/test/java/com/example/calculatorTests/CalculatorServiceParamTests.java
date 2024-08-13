package com.example.calculatorTests;

import com.example.calculatorTests.exceptions.EmptyArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParamTests {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> forCorrectCalculations() {
        return Stream.of(
                Arguments.of(-1.0, 1.0),
                Arguments.of(1.0, -1.0),
                Arguments.of(10_000_000.0, -10_000_000.0),
                Arguments.of(-1_000_000.0, 1_000_000.0)
        );
    }

    public static Stream<Arguments> forInputCheck() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(1.0, null),
                Arguments.of(null, 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("forCorrectCalculations")
    public void shouldReturnCorrectSum(Double num1, Double num2) {
        double expected = num1 + num2;
        double real = calculatorService.addition(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @ParameterizedTest
    @MethodSource("forCorrectCalculations")
    public void shouldReturnCorrectSubtract(Double num1, Double num2) {
        double expected = num1 - num2;
        double real = calculatorService.subtraction(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @ParameterizedTest
    @MethodSource("forCorrectCalculations")
    public void shouldReturnCorrectMultiply(Double num1, Double num2) {
        double expected = num1 * num2;
        double real = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @ParameterizedTest
    @MethodSource("forCorrectCalculations")
    public void shouldReturnCorrectDivision(Double num1, Double num2) {
        double expected = num1 / num2;
        double real = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @ParameterizedTest
    @MethodSource("forInputCheck")
    public void shouldThrowEmptyArgumentException(Double num1, Double num2) {
        Assertions.assertThrows(EmptyArgumentException.class,
                () -> calculatorService.checkIfNull(num1, num2));
    }


}
