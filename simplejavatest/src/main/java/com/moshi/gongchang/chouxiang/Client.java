package com.moshi.gongchang.chouxiang;

import com.moshi.gongchang.chouxiang.factory.Factory;
import com.moshi.gongchang.chouxiang.factory.impl.HaierFactory;

/**
 * @author liu peng bo
 * @date 2018/9/7
 */
public class Client {
    public static void main(String[] args) {
        Factory factory=new HaierFactory();

        System.out.println(factory.buildTv().get());
    }
}
