package math.bigdecimal;

import java.math.BigDecimal;

/**
 * @author liu peng bo
 * @date 2018/12/5
 */
public class TestMathContext {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("3.5");
        BigDecimal b=new BigDecimal("3.50");
        System.out.println(a.compareTo(b));
        /*BigDecimal b1=new BigDecimal("2.765");
        BigDecimal b2=new BigDecimal("2");
        BigDecimal b3=new BigDecimal("21111");

        MathContext  mathContext=new MathContext(3,RoundingMode.HALF_UP);

        BigDecimal c=a.multiply(b);
        BigDecimal c1=a.multiply(b1);
        BigDecimal c2=a.multiply(b2);


        BigDecimal d=a.multiply(b,mathContext);
        BigDecimal d1=a.multiply(b1,mathContext);
        BigDecimal d2=a.multiply(b2,mathContext);

        System.out.println("c:"+c);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);

        System.out.println("d:"+d);
        System.out.println("d1:"+d1);
        System.out.println("d2:"+d2);

        System.out.println(c.setScale(2, RoundingMode.HALF_UP));
        System.out.println(c1.setScale(2, RoundingMode.HALF_UP));
        System.out.println(c2.setScale(2, RoundingMode.HALF_UP));

        System.out.println(a.multiply(b3,mathContext));*/
    }
}
