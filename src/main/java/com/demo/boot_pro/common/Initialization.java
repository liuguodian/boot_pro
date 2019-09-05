package com.demo.boot_pro.common;

import com.demo.boot_pro.utils.VelocityUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

/**
 * 初始化
 * Created by DIAN on 2019/9/5.
 */
@Component
public class Initialization implements ApplicationListener<ApplicationReadyEvent> {
    private Logger LOG = Logger.getLogger(String.valueOf(Initialization.class));
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOG.info("============= initialize start ===========");
         //初始化模板引擎
        VelocityUtils.initVelocityEngine();
        LOG.info("============= initialize end ===========");
    }


}
