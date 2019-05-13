package com.sourcecode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liu peng bo
 * @date 2018/10/9
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring.xml");

        /*System.out.println(ac.getBean(XmlFactoryBean.class));
        System.out.println(ac.getBean(XmlFactoryBean.class).getObject());
        System.out.println(ac.getBean(XmlFactoryBean.class).getObject());*/
        //System.out.println(ac.getBean(Person.class));
        System.out.println(ac.getBean("xmlFactoryBean"));
        //System.out.println(ac.getBean("&xmlFactoryBean"));

        /*BeanDefinitionRegistry registry=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new ClassPathResource("spring.xml"));*/
    }
}
