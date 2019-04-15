package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Cat;
import com.service.ESService;
import com.service.impl.ESServiceImpl;

/**
 * @author liu peng bo
 * @date 2018/8/2
 */
public class IndexTest {
    public static void main(String[] args) {
        ESService service = new ESServiceImpl();
        Cat cat = new Cat();
        cat.setId("qwe");
        cat.setAge(12);
        cat.setSex("公猫");
        cat.setKind("test");
        cat.setName("test");
        cat.setDesc("test");
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        service.indexJson("anmial","cat","qwe",json);
    }
}
