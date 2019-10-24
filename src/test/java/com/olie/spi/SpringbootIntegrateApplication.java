package com.olie.spi;

import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.olie.SpringbootIntegrateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootIntegrateApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootIntegrateApplication.class);
    @Autowired
    private MybatisExampleService mybatisExampleService;

    @Test
    public void contextLoads() {

        ScheduleTask scheduleTask = mybatisExampleService.selectByPrimaryKey(12l);
        logger.info("result is {}", scheduleTask);

    }


}
