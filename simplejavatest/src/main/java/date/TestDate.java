package date;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2019/1/22
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        //1587063285
        //1587966978992
        Date date1=new Date(1587970132*1000L);
        System.out.println(date1);
    }
}
