package com.service;

import com.aspectj.TestAnnotation;
import com.aspectj.TestAround;
import com.domain.PayBo;
import com.domain.PayVo;
import org.springframework.stereotype.Component;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:36
 */
@Component
public class PayServiceImpl implements PayService {
    @Override
    @TestAnnotation
    public int pay() {
        System.out.println("pay suceess");
        int i=1/0;
        return 1;
    }

    @Override
    public PayVo pay(PayBo payBo) {
        PayVo payVo = new PayVo();
        payVo.setOrderId(payBo.getOrderId());
        payVo.setTradeStatus("1");
        System.out.println("pay pending");
        return payVo;
    }

    @Override
    @TestAround
    public int cancel(int id,PayBo payBo) {
        System.out.println("cancel sucess");
        return 123;
    }
}
