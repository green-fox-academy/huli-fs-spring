package com.greenfox.hulispring.controllers;

import com.greenfox.hulispring.HulispringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HulispringApplication.class)
@WebAppConfiguration
@EnableWebMvc
@AutoConfigureMockMvc

public class MainRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void jsonResponseTest() throws Exception {
    mockMvc
            .perform(get("/hello")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.messages[0].text").value("Hello EggDice"));
  }

  @Test
  public void databaseConnectionTest() throws Exception {
    mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(status().is2xxSuccessful());
  }
}
