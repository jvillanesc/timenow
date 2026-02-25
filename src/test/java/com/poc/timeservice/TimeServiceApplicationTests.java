package com.poc.timeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TimeServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void timeEndpointReturnsCurrentTime() throws Exception {
        mockMvc.perform(get("/api/time"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentTime").exists())
                .andExpect(jsonPath("$.timezone").exists())
                .andExpect(jsonPath("$.iso8601").exists());
    }
}
