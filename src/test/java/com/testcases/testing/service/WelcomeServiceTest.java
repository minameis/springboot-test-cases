package com.testcases.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testcases.testing.util.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class WelcomeServiceTest {

  private WelcomeService welcomeService;

  @BeforeEach
  public void setup() {
    welcomeService = mock(WelcomeService.class);
    when(welcomeService.welcome("World")).thenReturn("Hello, World!");
    when(welcomeService.welcome("Fred")).thenReturn("Hello, Fred!");
  }

  @Test
  @DisplayName("Should show default welcome message")
  void welcomeServiceReturnsHelloWorld(){
    assertEquals("Hello, World!", welcomeService.welcome("World"));
  }

  @Test
  @DisplayName("Should show custom welcome message")
  void welcomeServiceReturnsHelloFred(){
    assertEquals("Hello, Fred!", welcomeService.welcome("Fred"));
  }

  @Test
  @DisplayName("Should check World is not the same as User")
  void checkHelloUserDoesNotEqualHelloWorld(){
    assertNotEquals("Hello, User!", welcomeService.welcome("World"));
  }

}
