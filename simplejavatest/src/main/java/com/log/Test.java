package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liu peng bo
 * @date 2018/9/11
 */
public class Test {
    private static Logger logger= LoggerFactory.getLogger(Test.class);

    public static void testLog(){
        logger.info("123123123");
    }
    public static void main(String[] args) {

    }
}
