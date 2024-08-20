package com.example.calculatorTests;

import com.example.calculatorTests.exceptions.EmptyArgumentException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public CalculatorServiceImpl() {
        super();
    }

    public Double addition(Double num1, Double num2) {
        checkIfNull(num1, num2);
        return num1 + num2;
    }

    public Double subtraction(Double num1, Double num2) {
        checkIfNull(num1, num2);
        return num1 - num2;
    }

    public Double multiply(Double num1, Double num2) {
        checkIfNull(num1, num2);
        return num1 * num2;
    }

    public Double divide(Double num1, Double num2) {
        checkIfNull(num1, num2);
        if (num2 == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя");
        }
        return num1 / num2;
    }

    public void checkIfNull(Double num1, Double num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new EmptyArgumentException();
        }
    }
}
