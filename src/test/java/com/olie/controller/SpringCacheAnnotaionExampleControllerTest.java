package com.olie.controller;

import com.olie.SpringbootIntegrateApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootIntegrateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SpringCacheAnnotaionExampleControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void cacheableExample() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/cacheable")
                .contentType("application/x-www-form-urlencoded").param("key","2121"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void cacheEvictExample() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/cacheEvict")
                .contentType("application/x-www-form-urlencoded").param("key","2121"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}