package com.olie.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.olie.mybatis.mapper.ScheduleTaskMapper;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import com.olie.utils.aspects.log.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
public class MybatisExampleController {

    @Autowired
    private MybatisExampleService mybatisExampleService;

    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    //使用 JedisPool 获取访问 Redis
    @Autowired
    private JedisPool jedisPool;

    @PostMapping("/insert")
    public Object insert() {
        log.info("Hello MyBatis");
        final ScheduleTask scheduleTask = mybatisExampleService.selectByPrimaryKey(7995l);
        log.info(scheduleTask.toString());


        //pageHelper 分页
        List<ScheduleTask> allWithParam = scheduleTaskMapper.findAllWithParam(2, 1);
        PageInfo page = new PageInfo(allWithParam);
        log.info("PageInfo: {}", page);


        final int insert = mybatisExampleService.insert(new ScheduleTask().withBusinessNo(String.valueOf(10)));
        return insert;
    }

    @PostMapping("/logExample")
    @SystemLog(description = "日志拦截器样例")
    public Object logExample(@RequestParam("param") String param, HttpServletRequest request, HttpServletResponse response) {
        final ScheduleTask scheduleTask;
        try {
            scheduleTask = mybatisExampleService.selectByPrimaryKey(7995l);
        } catch (Exception e) {
            log.error("/logExample", e);
            throw e;
        }
        return scheduleTask;
    }



}
