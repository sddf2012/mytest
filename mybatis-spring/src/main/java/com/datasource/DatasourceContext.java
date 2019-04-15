package com.datasource;

/**
 * @author liu peng bo
 * @date 2018/9/3
 */
public class DatasourceContext {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setDatasource(String lookupKey) {
        THREAD_LOCAL.set(lookupKey);
    }

    public static String getDatasource() {
        return THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
