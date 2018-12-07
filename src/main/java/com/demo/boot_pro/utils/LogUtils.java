package com.demo.boot_pro.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtils {
	private Logger logger =null;
	 
    public LogUtils(Class clazz){
    	logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message, Object... var2){
        logger.info(message, var2);
    }
    
    public void debug(String message){
    	logger.debug(message);
    	logger.error(message);
    }
    
    public void error(String message,  Object... var2){
    	logger.error(message, var2);
    }
    
    public void warn(String message){
    	logger.warn(message);
    }
}
