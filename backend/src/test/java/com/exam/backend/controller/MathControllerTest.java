package com.exam.backend.controller;

import com.exam.backend.dto.DoMathRequest;
import com.exam.backend.exception.InvalidOperationException;
import com.exam.backend.services.MathOperatorImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(MathController.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MathControllerTest {
    @MockBean
    private MathOperatorImpl mathOperator;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_return_calculated_response() throws Exception {
        double operand1 = 10;
        double operand2 = 20;
        String operation = "*";
        DoMathRequest request = new DoMathRequest(operand1, operand2, operation);
        Mockito.when(mathOperator.doMath(operand1, operand2, operation)).thenReturn((double) 200);
        mockMvc.perform(post("/calculate")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
