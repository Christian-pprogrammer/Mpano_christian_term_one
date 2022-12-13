package com.exam.backend.services;

import com.exam.backend.exception.InvalidOperationException;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MathOperatorImplTest {
    MathOperatorImpl mathOperator = new MathOperatorImpl();
    public void multiply_success() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = 15;
        String operation = "*";
        Assert.assertEquals(mathOperator.doMath(operand1, operand2, operation), 150);
    }

    public void multiply_by_zero() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = 0;
        String operation = "*";
        Assert.assertEquals(mathOperator.doMath(operand1, operand2, operation), 0);
    }

    public void multiply_with_negative_number() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = -11;
        String operation = "*";
        Assert.assertEquals(mathOperator.doMath(operand1, operand2, operation), -110);
    }

}
