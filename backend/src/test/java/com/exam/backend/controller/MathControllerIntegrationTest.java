package com.exam.backend.controller;

import com.exam.backend.dto.DoMathRequest;
import com.exam.backend.payload.CalcResponse;
//import org.junit.runner.RunWith;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTest {
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String path = "/calculate";
    @Test
    public void doMathSuccess() throws JSONException {
        double operand1 = 14;
        double operand2 = 10;
        String operation = "*";
        DoMathRequest request = new DoMathRequest(operand1, operand2, operation);
        ResponseEntity<String> response =
                this.restTemplate.postForEntity("http://localhost:8080/calculate", request, String.class);
        JSONAssert.assertEquals("{calcResponse: 140}", String.valueOf(response.getBody()), false);
    }

}
