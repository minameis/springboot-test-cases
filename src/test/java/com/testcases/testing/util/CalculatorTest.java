package com.testcases.testing.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Standalone JUnit test
 * When testing pure logic
 *
 */
public class CalculatorTest {

  @Test
  @DisplayName("Calls calculator module to calculate 1 + 2 equals 3")
  void onePlusTwoEqualsThree() {
    // When
    Calculator calculator = new Calculator();
    int sum = calculator.sum(1,2);

    // Then
    assertEquals(3, sum);
  }
  @Test
  @DisplayName("Calls calculator module to calculate 1 + 2 does not equal 4")
  void onePlusTwoDoesNotEqualsFour() {
    // When
    Calculator calculator = new Calculator();
    int sum = calculator.sum(1,2);

    // Then
    assertNotEquals(4, sum);
  }
}
