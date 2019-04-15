package com.server;

import com.server.impl.MyServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
public class CxfPublishTest {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setServiceClass(MyService.class);
        factoryBean.setServiceBean(new MyServiceImpl());
        factoryBean.setAddress("http://localhost:8081/myservice");
        factoryBean.create();
    }
}
