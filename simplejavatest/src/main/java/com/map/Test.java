package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author liu peng bo
 * @date 2018/5/25
 */
public class Test {
    public static void main(String[] args) {
        int i=100;
        BiFunction biFunction= (key, oldValue) -> oldValue==null?i:(Integer)oldValue+i;
        Map<Integer, Integer> map = new HashMap<>(5);
        /*System.out.println(map.putIfAbsent(1,1));
        map.put(2, 2);
        Object a =  map.computeIfAbsent(1, b -> 1);
        System.out.println(a);
        System.out.println(map.size());*/
        map.put(1,1);
        map.compute(1,biFunction);
        map.compute(2,biFunction);

        System.out.println(map.get(1));
        System.out.println(map.get(2));

    }
}
