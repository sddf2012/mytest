package com.serialize;

import java.io.Serializable;

/**
 * @author liu peng bo
 * @date 2018/7/5
 */
public class Employee implements Serializable{

    private static final long serialVersionUID = 8925116061211498141L;
    public String name;
    public Address address;
    //public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + "---" + address.toString());
    }

}
