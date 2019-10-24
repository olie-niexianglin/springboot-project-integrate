package com.olie.service.impl;


import com.alibaba.fastjson.JSON;
import com.olie.mybatis.mapper.ScheduleTaskMapper;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MybatisExampleServiceImpl implements MybatisExampleService {

    private static final Logger logger = LoggerFactory.getLogger(MybatisExampleServiceImpl.class);
    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;



    @Override
    public int insert(ScheduleTask record) {
        return scheduleTaskMapper.insert(record);
    }

    @Override
    public ScheduleTask selectByPrimaryKey(Long id) {

        logger.info("MybatisExampleServiceImpl.selectByPrimaryKey param is：{}", JSON.toJSONString(id));

        return scheduleTaskMapper.selectByPrimaryKey(id);
    }
}
