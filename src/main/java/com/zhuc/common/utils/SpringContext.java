package com.zhuc.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by ZHUC on 2014/7/9.
 */
public class SpringContext implements ApplicationContextAware {
    private final static Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext ac = null;

    public static Object getBean(String name) {
        return ac.getBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
        logger.info("SpringContext init:" + ac);
    }
}
