package com.olie.controller;

import com.github.pagehelper.PageInfo;
import com.olie.mybatis.mapper.ScheduleTaskMapper;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MybatisExampleController {

    @Autowired
    private MybatisExampleService mybatisExampleService;

    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    @PostMapping("/insert")
    public Object insert() {
        log.info("Hello MyBatis");
        final ScheduleTask scheduleTask = mybatisExampleService.selectByPrimaryKey(7995l);
        log.info(scheduleTask.toString());


        List<ScheduleTask> allWithParam = scheduleTaskMapper.findAllWithParam(2, 1);
        PageInfo page = new PageInfo(allWithParam);
        log.info("PageInfo: {}", page);


        final int insert = mybatisExampleService.insert(new ScheduleTask().withBusinessNo(String.valueOf(10)));
        return insert;
    }

}
