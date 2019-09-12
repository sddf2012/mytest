package com.service;

import com.aspectj.TestAnnotation;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:36
 */
@Component
public class PayServiceImpl implements PayService{
    @Override
    @TestAnnotation
    public void pay() {
        System.out.println("支付成功");
    }

}
