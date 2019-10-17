package com.olie.service.impl;


import com.olie.mybatis.mapper.ScheduleTaskMapper;
import com.olie.mybatis.model.ScheduleTask;
import com.olie.service.MybatisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MybatisExampleServiceImpl implements MybatisExampleService {

    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    @Override
    public int insert(ScheduleTask record) {
        return scheduleTaskMapper.insert(record);
    }

    @Override
    public ScheduleTask selectByPrimaryKey(Long id) {
        return scheduleTaskMapper.selectByPrimaryKey(id);
    }
}
