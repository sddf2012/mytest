package com.service;

import com.domain.PayBo;
import com.domain.PayVo;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/22 9:36
 */
public interface PayService {
    int pay();

    PayVo pay(PayBo payBo);

    int cancel();
}
