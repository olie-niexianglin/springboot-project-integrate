package com.olie.controller;

import com.alibaba.fastjson.JSON;
import com.olie.controller.request.BaseRequest;
import com.olie.mybatis.mapper.ScheduleTaskMapper;
import com.olie.mybatis.mapper.TOrderMapper;
import com.olie.mybatis.model.TOrder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class ShardingJdbcExampleController {

    private static final Logger logger = LoggerFactory.getLogger(ShardingJdbcExampleController.class);

    @Autowired
    private TOrderMapper tOrderMapper;

    @GetMapping("/shardingJdbcExample")
    public ResponseEntity shardingJdbcExample(@PathParam("baseRequest") BaseRequest baseRequest) {

        log.info("BaseRequest is {}", JSON.toJSONString(baseRequest) );

        TOrder order = new TOrder();
        order.withName("hello world name");
        order.withType("hello world type");
        int insert = tOrderMapper.insert(order);

        logger.info("InterceptorExampleController.getRedisBody result is：{}" , JSON.toJSONString(new Object[]{baseRequest}));

        return new ResponseEntity(HttpStatus.OK);
    }
}
