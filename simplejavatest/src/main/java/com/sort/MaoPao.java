package com.sort;

/**
 * @author liu peng bo
 * @date 2018/9/5
 */
public class MaoPao {
    public static void sort(int[] in) {
        for (int i = 0; i <in.length-1 ; i++) {
            int a=0;
            int b=0;
            for (int j = 0; j < in.length-1-i; j++) {
                a=in[j];
                b=in[j+1];
                if(a>b){
                    in[j]=b;
                    in[j+1]=a;
                }
            }
        }
    }
}
