package com.moshi.gongchang.chouxiang.factory.impl;

import com.moshi.gongchang.chouxiang.factory.Factory;
import com.moshi.gongchang.chouxiang.product.BingXiang;
import com.moshi.gongchang.chouxiang.product.Tv;
import com.moshi.gongchang.chouxiang.product.impl.GeliBingXiang;
import com.moshi.gongchang.chouxiang.product.impl.GeliTv;

/**
 * @author liu peng bo
 * @date 2018/9/7
 */
public class GeliFactory implements Factory {
    @Override
    public Tv buildTv() {
        return new GeliTv();
    }

    @Override
    public BingXiang buildBingXiang() {
        return new GeliBingXiang();
    }
}
