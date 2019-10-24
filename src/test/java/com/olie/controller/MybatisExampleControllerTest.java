package com.olie.controller;

import com.alibaba.fastjson.JSON;
import com.olie.SpringbootIntegrateApplication;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootIntegrateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MybatisExampleControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisExampleControllerTest.class);

    //性能测试
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private MybatisExampleService mybatisExampleService;

    //MockBean 可以进行数据模拟操作
    @MockBean
    private MybatisExampleService mybatisExampleService;

    @Before
    public void setUp() {
        /**
         * 数据打桩  @MockBean
         * 因为 MybatisExampleController.logExample 方法依赖 mybatisExampleService.selectByPrimaryKey
         * 为了测试 logExample 的逻辑，我们暂且忽略 mybatisExampleService.selectByPrimaryKey
         * 让 mybatisExampleService.selectByPrimaryKey 始终返回固定的值
         *
         * 往往是依赖第三方接口
         */
        ScheduleTask scheduleTask = new ScheduleTask().withItemNo(100).withTaskType(20).withUpdatePin("Hello World");
        Mockito.when(mybatisExampleService.selectByPrimaryKey(Mockito.anyLong())).thenReturn(scheduleTask);
    }

    @Test
    @PerfTest(invocations = 1, threads = 1)
    public void logExample() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/logExample")
                .contentType("application/x-www-form-urlencoded")
                .param("param", "Hello World"))
                .andExpect(status().isOk())
                .andDo(print());
    }


}