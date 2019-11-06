package com.olie.controller;

import com.olie.mybatis.model.ScheduleTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class SpringCacheAnnotaionExampleController {


    @PostMapping("/cacheable")
    @Cacheable(cacheNames = "coffee", key = "#key")
    // redis key = coffee::key
    public Object cacheable(@PathParam("key") String key) {

        ScheduleTask scheduleTask = new ScheduleTask();
        scheduleTask.withBusinessNo("1213").withId(1231L);
        return scheduleTask;
    }

    @PostMapping("/cacheEvict")
    //清空所有 coffee (coffee::) 的缓存
    @CacheEvict(cacheNames = "coffee",allEntries = true)
    public Object cacheEvict() {

        return "Success";
    }


}
