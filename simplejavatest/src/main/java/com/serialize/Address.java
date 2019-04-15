package com.serialize;

import java.io.Serializable;

/**
 * @author liu peng bo
 * @date 2018/7/5
 */
public class Address implements Serializable{
    public String provice;
    public String city;
    public String street;

    @Override
    public String toString() {
        return "Address{" +
                "provice='" + provice + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
