package com.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
@Intercepts(value = {@Signature(type = Map.class, method = "get", args = {Object.class}),
        @Signature(type = Map.class, method = "put", args = {Object.class, Object.class})})
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) {
        if (invocation.getMethod().getName().equals("get")) {
            return get(invocation);
        } else   {
            return put(invocation);
        }
    }

    private Object get(Invocation invocation) {
        Object oldValue = "get ";
        try {
            oldValue = oldValue + String.valueOf(invocation.proceed());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return oldValue;
    }

    private Object put(Invocation invocation) {
        Object oldValue = "old ";
        try {
            oldValue = oldValue + String.valueOf(invocation.proceed());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return oldValue;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public static void main(String[] args) {
        MyInterceptor interceptor=new MyInterceptor();
        Map map=(Map)interceptor.plugin(new HashMap());
        System.out.println(map.put(1,1));
        System.out.println(map.get(1));
    }
}
