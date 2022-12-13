package com.exam.backend.controller;

import com.exam.backend.dto.DoMathRequest;
import com.exam.backend.exception.InvalidOperationException;
import com.exam.backend.payload.CalcResponse;
import com.exam.backend.services.MathOperatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class MathController {
    @Autowired
    MathOperatorImpl mathOperator;
    @PostMapping
    public CalcResponse doMath(
            @RequestBody DoMathRequest request
            ) throws InvalidOperationException {
        double res = mathOperator.doMath(request.getOperand1(), request.getOperand2(), request.getOperation());
        return new CalcResponse(res);
    }
}
