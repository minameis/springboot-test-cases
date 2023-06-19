package com.testcases.testing.model;

public class Greeting {

  private Long id;
  private String message;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Greeting(Long id, String message) {
    this.id = id;
    this.message = message;
  }
}
