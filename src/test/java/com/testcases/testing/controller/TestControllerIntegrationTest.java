package com.testcases.testing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.testcases.testing.service.CalculatorService;
import com.testcases.testing.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class TestControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private CalculatorService calculatorService;

  @MockBean
  private WelcomeService welcomeService;


  @Test
  void shouldGetDefaultWelcomeMessage() throws Exception {
    when(welcomeService.welcome("World")).thenReturn("Hello, World!");
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, World!"));

  }

  @Test
  void shouldGetCustomWelcomeMessage() throws Exception {
    when(welcomeService.welcome("Fred")).thenReturn("Hello, Fred!");
    mockMvc.perform(get("/?name=Fred"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, Fred!"));

  }


  @Test
  void shouldGetDefaultSum() throws Exception {
    when(calculatorService.sum(1,2)).thenReturn(3);
    mockMvc.perform(get("/sum"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("3"));

  }

  @Test
  void shouldGeCustomSum() throws Exception {
    when(calculatorService.sum(2,2)).thenReturn(4);
    mockMvc.perform(get("/sum?val1=2&val2=2"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("4"));

  }


}
