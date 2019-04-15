package com.reflect;

/**
 * @author liu peng bo
 * @date 2018/10/8
 */
public class Father implements Gf {

    private int a;

    private int b;

    @Override
    public int gf() {
        return 1;
    }

    public int fa() {
        return 2;
    }

    protected int fa2() {
        return 3;
    }

    private int fa3() {
        return 4;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
