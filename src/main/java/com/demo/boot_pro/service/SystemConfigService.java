package com.demo.boot_pro.service;

import com.demo.boot_pro.dao.SystemConfigMapper;
import com.demo.boot_pro.model.SystemConfig;
import com.demo.boot_pro.vo.ProResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by DIAN on 2018/12/6.
 */
@Service
public class SystemConfigService {


    private SystemConfigMapper systemConfigMapper;
    public ProResponseResult create(Map params) {
        ProResponseResult proResponseResult = new ProResponseResult();
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setConfigId(Integer.valueOf(params.get("configId").toString()));
        systemConfig.setParamDesc(params.get("paramDesc").toString());
        systemConfig.setParamName(params.get("paramName").toString());
        systemConfig.setParamValue(params.get("paramValue").toString());
        systemConfigMapper.insert(systemConfig);
        return proResponseResult;
    }

    public ProResponseResult get(Map params) {
        ProResponseResult proResponseResult = new ProResponseResult();
        SystemConfig systemConfig =systemConfigMapper.selectByPrimaryKey(Integer.valueOf(params.get("configId").toString()));
        proResponseResult.setData(systemConfig);
        return proResponseResult;
    }
}
