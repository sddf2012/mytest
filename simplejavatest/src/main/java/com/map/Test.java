package com.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu peng bo
 * @date 2018/5/25
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(5);
        System.out.println(map.putIfAbsent(1,1));
        map.put(2, 2);
        Object a =  map.computeIfAbsent(1, b -> 1);
        System.out.println(a);
        System.out.println(map.size());
    }
}
