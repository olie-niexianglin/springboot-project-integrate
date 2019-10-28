package com.olie.controller;

import com.alibaba.fastjson.JSON;
import com.olie.controller.request.BaseRequest;
import com.olie.utils.aspects.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class InterceptorExampleController {


    @GetMapping("/triggerInterceptor")
    public ResponseEntity getRedisBody(@PathParam("baseRequest") BaseRequest baseRequest) {

        log.info("BaseRequest is {}", JSON.toJSONString(baseRequest) );

        return new ResponseEntity(HttpStatus.OK);
    }

}
