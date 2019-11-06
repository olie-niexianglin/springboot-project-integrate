package com.olie.controller;

import com.olie.SpringbootIntegrateApplication;
import com.olie.mybatis.mapper.TOrderMapper;
import com.olie.mybatis.model.TOrder;
import com.olie.mybatis.model.TOrderExample;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootIntegrateApplication.class)
public class ShardingJdbcExampleControllerTest {


    //性能测试
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Autowired
    public TOrderMapper tOrderMapper;

    @Test
    @PerfTest(invocations = 1000, threads = 1)
    public void insert() throws Exception {

        TOrder order = new TOrder();
        order.withName("hello world name");
        order.withType("hello world type");
        int insert = tOrderMapper.insert(order);
    }

    @Test
    public void get() {

        List<TOrder> tOrders = tOrderMapper.findAllWithParam(1,10);
        System.out.println(tOrders);
    }




}