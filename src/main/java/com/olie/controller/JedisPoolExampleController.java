package com.olie.controller;

import com.alibaba.fastjson.JSON;
import com.olie.controller.request.BaseRequest;
import com.olie.utils.aspects.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@Slf4j
public class JedisPoolExampleController {


    //使用 JedisPool 获取访问 Redis
    @Autowired
    private JedisPool jedisPool;


    @PostMapping("/setRedis")
    @SystemLog(description = "JedisPool setRedis 样例")
    public Object setRedis(@RequestParam("key") String key, @RequestParam("value") String value) {

        //释放 Jedis 资源给 jedisPool 池
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }

        return value;
    }


    @PostMapping("/getRedis")
    @SystemLog(description = "JedisPool样例")
    public Object getRedis(@RequestParam("key") String key) {

        Object result = null;
        //释放 Jedis 资源给 jedisPool 池
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.get(key);
        }
        return result;
    }


    @PostMapping("/getRedisBody")
    @SystemLog(description = "RequestBody样例")
    public Object getRedisBody(@RequestBody BaseRequest baseRequest) {

        log.info("BaseRequest is {}", JSON.toJSONString(baseRequest) );

        return baseRequest;
    }


}
