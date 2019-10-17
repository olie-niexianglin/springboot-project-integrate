package com.olie.service;


import com.olie.mybatis.model.ScheduleTask;

public interface MybatisExampleService {

    int insert(ScheduleTask record);

    ScheduleTask selectByPrimaryKey(Long id);

}
