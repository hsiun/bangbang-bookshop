package com.bangbang.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-16 10:10
 */



@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void whenCookieAndHeaderExist() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/book")
                .cookie(new Cookie("token", "xxxxx"))
                .header("header", "aaaaa")
                .param("name", "高雄的测试")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }


    @Test
    public void whenDeleteSuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/book/1")
                .content("{\"name\":\"aaa\",\"content\":\"战争于和平\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void whenUpdateSuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/book/1")
                .content("{\"name\":\"aaa\",\"content\":\"战争于和平\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("aa"));
    }

    @Test
    public void whenCreateSuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .content("{\"name\":\"aaa\",\"content\":\"战争于和平\"}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("aa"));
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book")
                .param("name", "高雄的测试")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }


    @Test
    public void whenQueryBooksSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/condition")
                .param("name", "高雄的测试")
                .param("category", "测试")
                .param("size", "10")
                .param("page", "1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }


    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("aaa"))
                .andReturn().getResponse().getContentAsString();

        System.out.println("result = " + result);

    }


    @Test
    public void whenGenInfoFauil() throws Exception {
        String s = mockMvc.perform(MockMvcRequestBuilders.get("/book/10")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();
        System.out.println("s = " + s);
    }

}
