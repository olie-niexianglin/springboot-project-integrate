package com.olie.controller;

import com.olie.SpringbootIntegrateApplication;
import org.databene.contiperf.PerfTest;
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
public class JedisPoolExampleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void setRedis() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/setRedis")
                .contentType("application/x-www-form-urlencoded")
                .param("key", "message")
                .param("value", "Hello World"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getRedis() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/getRedis")
                .contentType("application/x-www-form-urlencoded")
                .param("key", "message"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}