package com.example.calculatorTests;

import com.example.calculatorTests.exceptions.EmptyArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTests {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    private final Double
            num1 = 1.0,
            num2 = -1.0,
            num3 = 1000000000.0,
            num4 = 2000000000.0,
            num5 = 0.0;

    @Test
    public void shouldReturnCorrectSumSmallNumbers() {
        double expected = num1 + num2;
        double real = calculatorService.addition(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectSumBigNumbers() {
        double expected = num3 + num4;
        double real = calculatorService.addition(num3, num4);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectSubtractSmallNumbers() {
        double expected = num1 - num2;
        double real = calculatorService.subtraction(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectSubtractBigNumbers() {
        double expected = num3 - num4;
        double real = calculatorService.subtraction(num3, num4);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectMultiplySmallNumbers() {
        double expected = num1 * num2;
        double real = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectMultiplyBigNumbers() {
        double expected = num3 * num4;
        double real = calculatorService.multiply(num3, num4);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectDivisionSmallNumbers() {
        double expected = num1 / num2;
        double real = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldReturnCorrectDivisionBigNumbers() {
        double expected = num3 / num4;
        double real = calculatorService.divide(num3, num4);
        Assertions.assertEquals(expected, real);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(num1, num5));
    }

    @Test
    public void shouldThrowEmptyArgumentExceptionIfAllNull() {
        Assertions.assertThrows(EmptyArgumentException.class,
                () -> calculatorService.checkIfNull(null, null));
    }

    @Test
    public void shouldThrowEmptyArgumentExceptionIfFirstNull() {
        Assertions.assertThrows(EmptyArgumentException.class,
                () -> calculatorService.checkIfNull(null, num2));
    }

    @Test
    public void shouldThrowEmptyArgumentExceptionIfSecondNull() {
        Assertions.assertThrows(EmptyArgumentException.class,
                () -> calculatorService.checkIfNull(num1, null));
    }


}
