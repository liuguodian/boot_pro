package com.demo.boot_pro.dao;

import com.demo.boot_pro.model.SystemConfig;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);
}