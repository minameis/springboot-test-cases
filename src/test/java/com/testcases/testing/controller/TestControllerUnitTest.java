package com.testcases.testing.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.testcases.testing.service.CalculatorService;
import com.testcases.testing.service.WelcomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * standalone JUnit with Mock
 */
public class TestControllerUnitTest {


  private TestController testController;

  @BeforeEach
  void setup() {
    WelcomeService welcomeService = mock (WelcomeService.class);
    when(welcomeService.welcome("World")).thenReturn("Hello, World!");
    when(welcomeService.welcome("Fred")).thenReturn("Hello, Fred!");

    CalculatorService calculatorService = mock(CalculatorService.class);
    when(calculatorService.sum(1,2)).thenReturn(3);
    when(calculatorService.sum(2,2)).thenReturn(4);
    testController = new TestController(calculatorService, welcomeService);
  }

  @Test
  void shouldGetDefaultSum() {
    assertEquals(new ResponseEntity<>(3, HttpStatus.OK), testController.sum(1,2));
  }

  @Test
  void shouldGetCustomSum() {
    assertEquals(new ResponseEntity<>(4, HttpStatus.OK), testController.sum(2,2));
  }
  @Test
  void shouldGetDefaultWelcomeMessage() {
    assertEquals(new ResponseEntity<>("Hello, World!", HttpStatus.OK), testController.home("World"));
  }

  @Test
  void shouldGetCustomWelcomeMessage() {
    assertEquals(new ResponseEntity<>("Hello, Fred!", HttpStatus.OK), testController.home("Fred"));
  }
}
