package com.testcases.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testcases.testing.util.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

  private CalculatorService calculatorService;

  @BeforeEach
  public void setup() {
    calculatorService = mock(CalculatorService.class);
    when(calculatorService.sum(2, 2)).thenReturn(4);
    when(calculatorService.sum(1, 2)).thenReturn(3);
  }

  @Test
  void onePlusTwoEqualsThree(){
    assertEquals(3, calculatorService.sum(1, 2));
  }

  @Test
  void TwoPlusTwoEqualsFour(){
    assertEquals(4, calculatorService.sum(2, 2));
  }

  @Test
  void onePlusTwoDoesNotEqualsFour(){
    Calculator calculator = new Calculator();
    assertNotEquals(4, calculatorService.sum(1, 2));
  }

}
