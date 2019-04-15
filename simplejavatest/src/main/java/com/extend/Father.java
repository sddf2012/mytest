package com.extend;

/**
 * @author liu peng bo
 * @date 2018/9/11
 */
public class Father {
    {
        System.out.println("this is father");
    }
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private void fa(){}

    public Father() {
        System.out.println("this is father constructor");

    }
}
