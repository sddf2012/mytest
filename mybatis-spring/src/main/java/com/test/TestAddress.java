package com.test;

import com.config.SpringConfig;
import com.entity.Address;
import com.service.AddressService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/10 15:17
 */
public class TestAddress {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        AddressService addressService= ac.getBean(AddressService.class);
        Address address=new Address();
        address.setAddressUserId(4);
        address.setAddressCountry("china");
        address.setAddressCity("北京");
        address.setAddressProvince("北京");
        address.setAddressDetail("sdfsdfsdfdsfsdf");
        addressService.insert(address);
    }
}
