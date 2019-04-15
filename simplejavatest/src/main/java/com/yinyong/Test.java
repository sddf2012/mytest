package com.yinyong;

/**
 * @author liu peng bo
 * @date 2018/10/10
 */
public class Test {
    public static void main(String[] args) {
        Y1 y1=new Y1();
        Y2 y2=new Y2();
        y2.setY1(y1);
        System.out.println(y2.getY1());
        System.out.println(y1);

        y2.setY1(null);
        System.out.println(y2.getY1());
        System.out.println(y1);
        /*y1=null;
        System.out.println(y2.getY1());
        System.out.println(y1);*/
    }
}
