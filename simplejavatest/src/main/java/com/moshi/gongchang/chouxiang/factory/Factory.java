package com.moshi.gongchang.chouxiang.factory;

import com.moshi.gongchang.chouxiang.product.BingXiang;
import com.moshi.gongchang.chouxiang.product.Tv;

/**
 * @author liu peng bo
 * @date 2018/9/7
 */
public interface Factory {
    Tv buildTv();

    BingXiang buildBingXiang();
}
