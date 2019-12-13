package com.service;

import com.aspectj.TestAnnotation;
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
        System.out.println("支付成功");
        return 1;
    }

    @Override
    public PayVo pay(PayBo payBo) {
        PayVo payVo = new PayVo();
        payVo.setOrderId(payBo.getOrderId());
        payVo.setTradeStatus("1");
        System.out.println("订单支付中");
        return payVo;
    }

    @Override
    public int cancel() {
        System.out.println("取消成功");
        return 0;
    }
}
