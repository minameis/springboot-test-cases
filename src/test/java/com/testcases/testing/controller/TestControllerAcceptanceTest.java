package com.testcases.testing.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerAcceptanceTest {

  @LocalServerPort
  int randomServerPort;

  private RestTemplate restTemplate;
  private String url;

  @BeforeEach
  void setUp() {
    restTemplate = new RestTemplate();
    url = "http://localhost:" + randomServerPort + "/";
  }

  @Test
  void shouldGetDefaultWelcomeMessage() throws Exception {
    ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Hello, World!", responseEntity.getBody());
  }

  @Test
  void shouldGetCustomWelcomeMessage() throws Exception {
    ResponseEntity responseEntity = restTemplate.getForEntity(url + "?name=Fred", String.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Hello, Fred!", responseEntity.getBody());
  }

  @Test
  void shouldGetDefaultSum() throws Exception {
    ResponseEntity responseEntity = restTemplate.getForEntity(url+"/sum", Integer.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(3, responseEntity.getBody());
  }

  @Test
  void shouldGetCustomSum() throws Exception {
    ResponseEntity responseEntity = restTemplate.getForEntity(url + "/sum?val1=2&val2=2", Integer.class);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(4, responseEntity.getBody());
  }

}


