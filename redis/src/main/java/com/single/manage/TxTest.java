package com.single.manage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class TxTest {
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        RedisTemplate redisTemplate = SpringContext.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("tx1", "tx1");
        int i = 1 / 0;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ManageConfig.class);
        TxTest txTest=new TxTest();
        txTest.test();
    }

}
