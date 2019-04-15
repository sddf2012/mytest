package com.reflect;

/**
 * @author liu peng bo
 * @date 2018/10/8
 */
public class Son extends Father {
    private int c;

    private int d;

    public int s1() {
        return 11;
    }

    private int s2() {
        return 12;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
