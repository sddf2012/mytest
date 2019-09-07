package math.bigdecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/17 17:31
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("3.5");
        BigDecimal b=new BigDecimal("3.50");
        BigDecimal d=null;
        List<BigDecimal> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        System.out.println(list.stream().reduce(BigDecimal.ZERO,BigDecimal::add)); ;

    }
}
