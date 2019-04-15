package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/11
 */
public class Log1 {
    private Logger logger = LoggerFactory.getLogger(Log1.class);

    public void t1() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            String err = "t1异常!";
            //logger.error(err, e);
            throw new Exception(err,e);
        }
    }

    public void t2() {
        try {
            t1();
        } catch (Exception e) {
            throw new RuntimeException("t2异常!", e);
        }

    }

    public void t3(){

        try {
            t2();
        } catch (Exception e) {
            logger.error("t3异常!"+e.getMessage(),e);
            throw new RuntimeException("t3异常+"+new Date()+"!", e);
        }
    }
}
