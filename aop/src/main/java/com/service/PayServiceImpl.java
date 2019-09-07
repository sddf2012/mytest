package com.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:36
 */
@Component
@Qualifier("payService")
public class PayServiceImpl implements PayService{
    @Override
    public void pay() {
        System.out.println("支付成功");
    }

    @Override
    public void callback() {
        System.out.println("callback");
    }
}
