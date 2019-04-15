package com.moshi.gongchang.chouxiang.factory.impl;

import com.moshi.gongchang.chouxiang.factory.Factory;
import com.moshi.gongchang.chouxiang.product.BingXiang;
import com.moshi.gongchang.chouxiang.product.Tv;
import com.moshi.gongchang.chouxiang.product.impl.HaierBingXiang;
import com.moshi.gongchang.chouxiang.product.impl.HaierTv;

/**
 * @author liu peng bo
 * @date 2018/9/7
 */
public class HaierFactory implements Factory {
    @Override
    public Tv buildTv() {
        return new HaierTv();
    }

    @Override
    public BingXiang buildBingXiang() {
        return new HaierBingXiang();
    }
}
