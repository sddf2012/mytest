package com.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/9/4
 */
public enum DatasourceEnum {
    /**
     *
     */
    D1("d1"),
    /**
     *
     */
    D2("d2");

    public final static List<String> lookupKeyList = new ArrayList<>();

    static {
        for (DatasourceEnum datasourceEnum : values()) {
            lookupKeyList.add(datasourceEnum.getLookupKey());
        }
    }

    private String lookupKey;

    DatasourceEnum(String lookupKey) {
        this.lookupKey = lookupKey;
    }

    public String getLookupKey() {
        return lookupKey;
    }

    public static void main(String[] args) {
        System.out.println(DatasourceEnum.lookupKeyList.size());

    }
}
