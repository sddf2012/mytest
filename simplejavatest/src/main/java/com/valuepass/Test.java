package com.valuepass;

/**
 * @author liu peng bo
 * @date 2018/9/20
 */
public class Test {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void change(int j){
        j=5;
        System.out.println(j);
    }

    public void change2(Integer j){
        j=5;
        System.out.println(j);
    }

    public void changes(String j){
        j="2";
        System.out.println(j);
    }


    public static void main(String[] args) {
        int a = 1;
        Integer b=new Integer(2);
        Test test = new Test();
        /*test.change2(b);
        System.out.println(b);*/

        /*String s="1";
        test.changes(s);
        System.out.println(s);*/
        String s1="123";
        String s2="123";
        s2="234";
        System.out.println(s1);
    }
}
