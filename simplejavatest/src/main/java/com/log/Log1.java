package com.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/9/11
 */
@Slf4j
public class Log1 {
    public static void main(String[] args) {
        try {
            int i=1/0;
        }
        catch(Exception e){
            log.error("13213,{}","qwe",e);
        }
    }
}
