package com.example.calculatorTests;

public interface CalculatorService {

    Double addition(Double num1, Double num2);

    Double subtraction(Double num1, Double num2);

    Double multiply(Double num1, Double num2);

    Double divide(Double num1, Double num2);

    void checkIfNull(Double num1, Double num2);
}
