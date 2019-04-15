package com.extend;

/**
 * @author liu peng bo
 * @date 2018/9/11
 */
public class Son extends Father{
    {
        System.out.println("this is son");
    }

    public Son() {
        System.out.println("this is son constructor");

    }

    public static void main(String[] args) {
        Son son=new Son();
        son.setI(1);
        System.out.println(son.getI());
    }
}
