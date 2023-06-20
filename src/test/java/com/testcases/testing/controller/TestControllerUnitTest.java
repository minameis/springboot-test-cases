package com.testcases.testing.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.testcases.testing.service.CalculatorService;
import com.testcases.testing.service.WelcomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * standalone JUnit with Mock
 *
 * Unit testing relies on mock objects being created to test sections of code that are not yet part
 * of a complete application. Mock objects fill in for the missing parts of the program
 *
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
  @DisplayName("Should show default welcome message")
  void shouldGetDefaultWelcomeMessage() {
    assertEquals(new ResponseEntity<>("Hello, World!", HttpStatus.OK), testController.home("World"));
  }

  @Test

  @DisplayName("Should show custom welcome message")
  void shouldGetCustomWelcomeMessage() {
    assertEquals(new ResponseEntity<>("Hello, Fred!", HttpStatus.OK), testController.home("Fred"));
  }

  @Test
  @DisplayName("Should do default sum which is 1 + 2")
  void shouldGetDefaultSum() {
    assertEquals(new ResponseEntity<>(3, HttpStatus.OK), testController.sum(1,2));
  }

  @Test
  @DisplayName("Should do default sum - parameters passing 2 + 2")
  void shouldGetCustomSum() {
    assertEquals(new ResponseEntity<>(4, HttpStatus.OK), testController.sum(2,2));
  }

}
