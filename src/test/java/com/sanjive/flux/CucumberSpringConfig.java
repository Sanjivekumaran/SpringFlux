package com.sanjive.flux;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringFluxApplication.class)
public class CucumberSpringConfig {

	@Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
