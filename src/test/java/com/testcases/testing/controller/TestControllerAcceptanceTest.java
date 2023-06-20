package com.testcases.testing.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Acceptance test cases are based on user requirements and function processing.
 * It is formal testing, which governs whether the software is compatible
 * with particular requirements or not.
 *
 */
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
  @DisplayName("Should show default welcome message")
  void shouldGetDefaultWelcomeMessage() throws Exception {
    // When
    ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);

    // Then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Hello, World!", responseEntity.getBody());
  }

  @Test
  @DisplayName("Should show custom welcome message")
  void shouldGetCustomWelcomeMessage() throws Exception {
    // When
    ResponseEntity responseEntity = restTemplate.getForEntity(url + "?name=Fred", String.class);

    // Then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("Hello, Fred!", responseEntity.getBody());
  }

  @Test
  @DisplayName("Should do default sum which is 1 + 2")
  void shouldGetDefaultSum() throws Exception {
    // When
    ResponseEntity responseEntity = restTemplate.getForEntity(url+"/sum", Integer.class);

    // Then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(3, responseEntity.getBody());
  }

  @Test
  @DisplayName("Should do default sum - parameters passing 2 + 2")
  void shouldGetCustomSum() throws Exception {
    // When
    ResponseEntity responseEntity = restTemplate.getForEntity(url + "/sum?val1=2&val2=2", Integer.class);

    // Then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(4, responseEntity.getBody());
  }

}


