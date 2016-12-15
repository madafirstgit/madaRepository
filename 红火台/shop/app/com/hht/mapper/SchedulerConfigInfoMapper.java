package com.hht.mapper;

import com.hht.models.SchedulerConfigInfo;

import java.util.List;
import java.util.Map;

public interface SchedulerConfigInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SchedulerConfigInfo record);

    int insertSelective(SchedulerConfigInfo record);

    SchedulerConfigInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchedulerConfigInfo record);

    int updateByPrimaryKey(SchedulerConfigInfo record);

    List<SchedulerConfigInfo> selectAllScheduler(Map<String,Object> map);
}