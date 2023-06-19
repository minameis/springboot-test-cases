package com.testcases.testing.service;

import com.testcases.testing.model.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();


  public  String  welcome(String name) {
    return String.format(template, name);
  }

  public Greeting greeting(String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
