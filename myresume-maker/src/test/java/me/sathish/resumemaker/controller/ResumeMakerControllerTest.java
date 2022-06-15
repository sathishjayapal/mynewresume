package me.sathish.resumemaker.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ResumeMakerController.class)
@ActiveProfiles("local")
class ResumeMakerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void rootHello() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        Assertions.assertEquals("OK", result.getResponse().getContentAsString());
    }

    @Test
    void makeResume() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/makeResume").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        Assertions.assertEquals(HttpStatus.OK, result.getResponse().getStatus());
    }
}
