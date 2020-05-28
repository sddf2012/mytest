package my.test;

import com.entity.Address;
import com.init.SqlSessionUtils;
import com.mapper.AddressMapper;
import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author 创建者中文名
 * date: 2019-1-10 16:43
 */
public class TestAddress {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address address=new Address();
        address.setAddressUserId(5);
        address.setAddressCountry("china");
        address.setAddressCity("qwqwq");
        address.setAddressProvince("asdas");
        address.setAddressDetail("sdfsdfsdfdsfsdf");
        addressMapper.insert(address);
        sqlSession.commit();
        /*Address address= addressMapper.selectByUserId(1);
        Map<String,Object> map= addressMapper.selectMapByUserId(1);*//*
        sqlSession.commit();
        System.out.println(address.toString());*/


        /*Address address = new Address();
        address.setAddressId(11);
        List<Address> addressList = addressMapper.selectByAddress(null);
        //sqlSession.commit();
        addressList.forEach(a ->
                System.out.println(a.toString())

        );*/
    }
}
