package com.demo.boot_pro.base;

import com.demo.boot_pro.BootProApplication;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;
import java.util.Map;
/**
 * Created by DIAN on 2019/2/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootProApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest extends AbstractTestNGSpringContextTests {
    private MockMvc mockMvc;

    private Cookie cookie;

    private MockHttpSession session;

    private Map jsonMap;


    @Autowired
    protected WebApplicationContext context;

    @BeforeClass
    public void beforeClass(){
        try{
            String path=this.getClass().getClassLoader().getResource("testng/json/"+this.getClass().getSimpleName()+".json").getPath();
            String fileStr = FileUtils.readFileToString(new File(path)).trim();
            jsonMap = JSON.parseObject(fileStr,Map.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        //初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @BeforeMethod
    public void beforeMethod() {
        //初始化Cookie
        cookie = new Cookie("userId","bcddsjbo626511");
        session=new MockHttpSession();
        session.setAttribute("account","bcddsjbo626511");
        session.setAttribute("accountName", "ceshi");
        session.setAttribute("_const_cas_assertion_","nukk");
    }

    @AfterMethod
    public void afterMethod() {

    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

    public Cookie getCookie() {
        return cookie;
    }
    public MockHttpSession getSession() {
        return session;
    }

    public String getParams(String method)  {

        Map params=MapUtils.getMap(jsonMap,method);
        String requestParams=MapUtils.getString(params,"requestParams");
        return requestParams;
    }

    public String geValueByKey(String method,String key)  {
        Map params=MapUtils.getMap(jsonMap,method);
        String response=MapUtils.getString(params,"key");
        return response;
    }
}
