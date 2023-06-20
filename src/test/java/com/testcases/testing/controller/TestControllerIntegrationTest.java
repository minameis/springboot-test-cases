package com.testcases.testing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.testcases.testing.service.CalculatorService;
import com.testcases.testing.service.WelcomeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration test cases mainly focus on the data transfer between the modules as
 * modules/components that are already unit tested,
 * interface between the modules and integrated links
 */
@WebMvcTest
public class TestControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CalculatorService calculatorService;

  @MockBean
  private WelcomeService welcomeService;


  @Test
  @DisplayName("Should show default welcome message")
  void shouldGetDefaultWelcomeMessage() throws Exception {
    // When
    when(welcomeService.welcome("World")).thenReturn("Hello, World!");

    // Then
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, World!"));
  }

  @Test
  @DisplayName("Should show custom welcome message")
  void shouldGetCustomWelcomeMessage() throws Exception {
    // When
    when(welcomeService.welcome("Fred")).thenReturn("Hello, Fred!");

    // Then
    mockMvc.perform(get("/?name=Fred"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, Fred!"));
  }


  @Test
  @DisplayName("Should do default sum which is 1 + 2")
  void shouldGetDefaultSum() throws Exception {
    // When
    when(calculatorService.sum(1,2)).thenReturn(3);

    // Then
    mockMvc.perform(get("/sum"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("3"));
  }

  @Test
  @DisplayName("Should do default sum - parameters passing 2 + 2")
  void shouldGeCustomSum() throws Exception {
    // When
    when(calculatorService.sum(2,2)).thenReturn(4);

    // Then
    mockMvc.perform(get("/sum?val1=2&val2=2"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("4"));
  }


}
