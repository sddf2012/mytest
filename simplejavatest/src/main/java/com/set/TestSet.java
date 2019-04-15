package com.set;

/**
 * @author liu peng bo
 * @date 2018/6/14
 */
public class TestSet {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*Set set=new LinkedHashSet();
        Object[] o= set.toArray();
        System.out.println(o.length);*/
        Class c = Class.forName("com.set.Set2");
        Set2 set2 = (Set2) c.newInstance();
    }
}
