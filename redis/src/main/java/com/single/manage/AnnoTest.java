package com.single.manage;

import com.single.service.AnnotationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu peng bo
 * @date 2019/3/6
 */
public class AnnoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ManageConfig.class);
        AnnotationService service = ac.getBean(AnnotationService.class);
        System.out.println(service.get("123"));
    }
}
