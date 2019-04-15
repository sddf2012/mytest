package com.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
public class Test {
    public static void main(String[] args) throws Exception {
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:8081/myservice?wsdl");
        Object[] re = client.invoke("hello2");
        System.out.println(re);
    }
}
