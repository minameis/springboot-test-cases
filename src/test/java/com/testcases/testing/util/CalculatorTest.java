package com.testcases.testing.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;


/**
 * Standalone JUnit test
 * JUnit is a unit testing framework that focuses on writing and executing test cases for individual units of code
 */
public class CalculatorTest {

  @Test
  void onePlusTwoEqualsThree(){
    Calculator calculator = new Calculator();
    assertEquals(3, calculator.sum(1,2));
  }
  @Test
  void onePlusTwoDoesNotEqualsFour(){
    Calculator calculator = new Calculator();
    assertNotEquals(4, calculator.sum(1,2));
  }
}
