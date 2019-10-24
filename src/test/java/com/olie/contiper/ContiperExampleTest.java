package com.olie.contiper;

import com.alibaba.fastjson.JSON;
import com.olie.SpringbootIntegrateApplication;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@SpringBootTest(classes = SpringbootIntegrateApplication.class)

public class ContiperExampleTest {

    private static final Logger logger = LoggerFactory.getLogger(ContiperExampleTest.class);

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Autowired
    private MybatisExampleService mybatisExampleService;


    @Test
    @PerfTest(invocations = 100, threads = 10)
    public void contiperfTest() throws Exception {
        ScheduleTask scheduleTask = mybatisExampleService.selectByPrimaryKey(7995l);
        logger.info("MybatisExampleControllerTest.contiperfTest result is：{}", JSON.toJSONString(scheduleTask));
    }

}