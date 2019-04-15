package com;

import com.service.ESService;
import com.service.impl.ESServiceImpl;

/**
 * @author liu peng bo
 * @date 2018/8/8
 */
public class UpdateTest {
    public static void main(String[] args) {
        ESService service = new ESServiceImpl();
        //service.indexJson("test","t","3","{\"address\":{\"country\":\"china\",\"province\":\"anhui\"},\"name\":{\"firstname\":\"qwe\",\"lastname\":\"asd\"},\"id\":\"6\"}\n");
         service.delete("test","t","3");
    }
}
