package com.config;

import com.server.MyService;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
@Configuration
@ComponentScan("com")
public class WSConfig {
    @Bean
    public Server server(MyService myService) {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("/myservice");
        factoryBean.setServiceBean(myService);
        return factoryBean.create();
    }
}
