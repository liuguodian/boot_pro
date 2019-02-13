package com.demo.boot_pro.controller;

import com.demo.boot_pro.base.BaseTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestControllerTest extends BaseTest {

    @Test
    public void testIndex() throws Exception {
        ResultActions resultActions = getMockMvc().perform(post("/test/hello")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE) //数据的格式
                .content(getParams("hello")));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(jsonPath("$.errCode").value(0));
    }
    @Test
    public void testSay () throws Exception {
        ResultActions resultActions = getMockMvc().perform(post("/test/say")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE) //数据的格式
                .content(getParams("hello")));
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(jsonPath("$.age").value(0));
    }
}
