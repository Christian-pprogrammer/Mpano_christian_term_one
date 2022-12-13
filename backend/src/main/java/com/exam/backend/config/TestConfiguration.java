package com.exam.backend.config;

import com.exam.backend.services.MathOperatorImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfiguration {
    @Bean
    @Primary
    public MathOperatorImpl mathOperator() {
        return Mockito.mock(MathOperatorImpl.class);
    }
}