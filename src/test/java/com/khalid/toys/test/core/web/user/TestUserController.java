package com.khalid.toys.test.core.web.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.khalid.toys.core.domain.Message;
import com.khalid.toys.core.utils.FastJsonUtil;
import com.khalid.toys.test.core.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 费玥 on 2016/12/12.
 */
public class TestUserController extends TestBase {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void testIsLoginAndGetInfo(){
        String uri = "/user/isLoginAndGetInfo";
    }

    @Test
    public void testLoginNameExist() throws Exception {
        String uri = "/user/existName";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON).param("loginName","feiyue"))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertEquals("错误，正确的返回值为True",true,FastJsonUtil.string2obj(result, Message.class).getMessage());
    }


    @Test
    public void testMobileExist() throws Exception {
        String uri = "/user/existMobile";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON).param("mobile","17701085294"))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertEquals("错误，正确的返回值为True",true,FastJsonUtil.string2obj(result, Message.class).getMessage());
    }


    @Test
    public void testFollow() throws Exception {
        String uri = "/user/wwww/follow/qwwe";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertEquals("错误，正确的返回值为True", Message.MessageResult.SUCCESS,FastJsonUtil.string2obj(result, Message.class).getResult());
    }
}
