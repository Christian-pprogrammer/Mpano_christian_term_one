package com.exam.backend.services;

import com.exam.backend.exception.InvalidOperationException;

public interface MathOperator {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
