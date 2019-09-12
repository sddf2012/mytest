package com.service;

import org.springframework.stereotype.Service;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/9/9 14:07
 */
public class CallbackServiceImpl implements CallbackService {

    @Override
    public void callback() {
        System.out.println("回调成功");
    }
}
