package com.trevorbye.web;


import com.trevorbye.model.PunchCardEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.util.Date;

public class RESTControllerTest {
    private MockMvc mockMvc;
    private RESTController controller;

    @Before
    public void setUp() throws Exception {
        controller = new RESTController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void createCard_ShouldReturn200Status() throws Exception {
        PunchCardEntity testPayload = new PunchCardEntity();
        testPayload.setBody("testBody");
        testPayload.setCompany("Darigold");
        testPayload.setCompanyId(877);
        testPayload.setCssColorAndStyle(".test {color: black}");
        testPayload.setCssPositioning(".test {position: relative}");
        testPayload.setTitle("Hello World.");
        testPayload.setNumberOfPunches(8);
        testPayload.setExpirationDateInclusive(true);
        testPayload.setExpirationDate(new Date(new Date().getTime()));

        mockMvc.perform(MockMvcRequestBuilders.post(new URI("/createCard"))
                .content(PunchCardEntity.asJsonString(testPayload))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().is(200));
    }
}
