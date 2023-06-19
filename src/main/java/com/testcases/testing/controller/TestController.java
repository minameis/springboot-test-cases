package com.testcases.testing.controller;

import com.testcases.testing.model.Greeting;
import com.testcases.testing.service.CalculatorService;
import com.testcases.testing.service.WelcomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


  private final CalculatorService calculatorService;

  private final WelcomeService welcomeService;



  public TestController(CalculatorService calculatorService, WelcomeService welcomeService) {
    this.calculatorService = calculatorService;
    this.welcomeService = welcomeService;
  }

  @GetMapping("/")
  public ResponseEntity<String> home(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new ResponseEntity<>( welcomeService.welcome(name), HttpStatus.OK);
  }


  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return welcomeService.greeting(name);
  }

  @GetMapping("/sum")
  public ResponseEntity<Integer> sum(@RequestParam(value = "val1", defaultValue = "1") int val1,
      @RequestParam(value = "val2", defaultValue = "2") int val2 ) {
    return new ResponseEntity<>(calculatorService.sum(val1,val2), HttpStatus.OK);
  }
}
