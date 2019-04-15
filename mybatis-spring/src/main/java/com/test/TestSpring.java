package com.test;

import com.config.SpringConfig;
import com.entity.User;
import com.github.pagehelper.PageInfo;
import com.service.UserMapperService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/30
 */
public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserMapperService userMapperService= ac.getBean(UserMapperService.class);
        /*User result = userMapperService.getById("2");
        System.out.println("d1:"+result.toString());
       List<User> list=userMapperService.findByName("1");
        System.out.println("d2:"+list.size());*/
        //userMapperService.test2("6");
        PageInfo<User> pageInfo=  userMapperService.testFenye2("1",2,2);
        List<User> list=pageInfo.getList();
        list.forEach(l->{
            System.out.println(l.toString());
        });
    }
}
