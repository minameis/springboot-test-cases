package com.testcases.testing.service;

import com.testcases.testing.util.Calculator;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {


  public int sum(int a, int b) {
    Calculator calculator = new Calculator();
    return calculator.sum(a,b);
  }

  public int sum(Integer val1, Integer val2) {
    Integer result = null;
    if (val1 != null && val2 != null) {
      result = sum(val1,val2);
    }
    return result;
  }


}
