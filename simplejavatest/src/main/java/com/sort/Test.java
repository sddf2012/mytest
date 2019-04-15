package com.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liu peng bo
 * @date 2018/9/5
 */
public class Test {
    public static void main(String[] args) {
        int[] in=new int[20];
        for (int i = 0; i < in.length; i++) {
            in[i]= new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(in));
        MaoPao.sort(in);
        System.out.println(Arrays.toString(in));
    }
}
