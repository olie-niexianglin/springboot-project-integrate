package com.olie.controller.exception;

import com.alibaba.fastjson.JSON;
import com.olie.controller.request.BaseRequest;
import com.olie.utils.ResponseEntity;
import com.olie.utils.aspects.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@Slf4j
public class GlobalExceptionExampleController {

    @GetMapping(path = "/getExceptionExample")
    public ResponseEntity getException() {

        throw new RuntimeException("RuntimeException");
    }

    @GetMapping("/getMyCustomerException")
    public ResponseEntity getMyCustomerException() {

        throw new MyException("MyException");
    }

}
