package com.domain;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/12/12 11:06
 */
@Data
public class PayBo {
    private Long orderId;

    private BigDecimal bigDecimal;

    public PayBo() {
    }

    public PayBo(Long orderId, BigDecimal bigDecimal) {
        this.orderId = orderId;
        this.bigDecimal = bigDecimal;
    }
}
