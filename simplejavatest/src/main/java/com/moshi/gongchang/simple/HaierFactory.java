package com.moshi.gongchang.simple;

import com.moshi.gongchang.simple.product.HaierBingxiang;
import com.moshi.gongchang.simple.product.HaierTv;
import com.moshi.gongchang.simple.product.Product;

/**
 * @author liu peng bo
 * @date 2018/9/7
 */
public class HaierFactory {
    public static Product build(int type) throws Exception {
        Product product;
        switch (type) {
            case 1:
                product = new HaierBingxiang();
                break;
            case 2:
                product = new HaierTv();
                break;
            default:
                throw new Exception("");
        }
        return product;
    }
}
