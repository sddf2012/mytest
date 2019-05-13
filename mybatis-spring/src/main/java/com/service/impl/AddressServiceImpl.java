package com.service.impl;

import com.datasource.DesignationDatasource;
import com.entity.Address;
import com.mapper.AddressMapper;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/10 15:15
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    @DesignationDatasource("d1")
    public void insert(Address address) {
        addressMapper.insert(address);
        int i=1/0;
    }
}
