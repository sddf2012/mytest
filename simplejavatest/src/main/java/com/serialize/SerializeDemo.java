package com.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author liu peng bo
 * @date 2018/7/5
 */
public class SerializeDemo {
    public static void main(String [] args)
    {

        Address address=new Address();
        address.provice="p1";
        address.city="c1";
        address.street="s1";

        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address =address;
        e.number=123;

        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("E:/test/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
