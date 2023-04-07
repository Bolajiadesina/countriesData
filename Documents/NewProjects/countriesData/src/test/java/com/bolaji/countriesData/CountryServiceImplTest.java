package com.bolaji.countriesData;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bolaji.countriesData.controllers.DemoController;

public class CountryServiceImplTest {
  public class HelpControllerTest {
 
    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
      mockMvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
    }

    @Test   
    public void main() throws Exception {
      // mockMvc.perform(get("/bolaji"))
      //     .andExpect(status().isOk())
      //     .andExpect(view().name("bolaji"));
    }
  }

}
  