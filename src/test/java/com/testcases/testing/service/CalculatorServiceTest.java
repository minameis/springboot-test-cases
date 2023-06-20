package com.testcases.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.testcases.testing.util.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
  @DisplayName("Should check 1 plus 2 equals 3")
  void onePlusTwoEqualsThree(){
    assertEquals(3, calculatorService.sum(1, 2));
  }

  @Test
  @DisplayName("Should check 2 plus 2 equals 4")
  void TwoPlusTwoEqualsFour(){
    assertEquals(4, calculatorService.sum(2, 2));
  }

  @Test
  @DisplayName("Should check 1 plus 2 does not equal 4")
  void onePlusTwoDoesNotEqualsFour(){
    Calculator calculator = new Calculator();
    assertNotEquals(4, calculatorService.sum(1, 2));
  }

}
