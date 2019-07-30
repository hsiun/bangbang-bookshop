package com.bangbang.controller;

import com.bangbang.BookshopWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-18 19:50
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookshopWebApplication.class)
@AutoConfigureMockMvc
public class FileControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void whenUploadSuccess() throws Exception{
        String file = mockMvc.perform(MockMvcRequestBuilders.multipart("/file/upload")
                .file(new MockMultipartFile("file", "text.txt", "multipart/form-data", "Hello,World".getBytes("UTF-8"))))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println("file = " + file);
    }


}
