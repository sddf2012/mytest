package com.single.manage;

import java.io.Serializable;

/**
 * @author liu peng bo
 * @date 2018/11/15
 */
public class TestBean implements Serializable {

    private static final long serialVersionUID = -5059291947936390690L;
    private int i;
    private String j;

    public TestBean() {
    }

    public TestBean(int i, String j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "i=" + i +
                ", j='" + j + '\'' +
                '}';
    }
}
