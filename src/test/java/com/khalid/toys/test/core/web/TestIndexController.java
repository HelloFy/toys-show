package com.khalid.toys.test.core.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.khalid.toys.test.core.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 费玥 on 2016/12/8.
 */


public class TestIndexController extends TestBase {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationConnect;

    private MockHttpSession mockHttpSession;

    @Before
    public void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
        mockHttpSession = new MockHttpSession();

    }

    @Test
    public void testIndex() throws Exception {
        String uri = "/";
        mockHttpSession.setAttribute("user",user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andReturn();
    }

}
