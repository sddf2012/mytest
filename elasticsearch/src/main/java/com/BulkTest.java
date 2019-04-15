package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Cat;
import com.model.DocMO;
import com.service.ESService;
import com.service.impl.ESServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author liu peng bo
 * @date 2018/8/2
 */
public class BulkTest {
    public static void main(String[] args) {
        ESService service = new ESServiceImpl();
        List<DocMO> list = new ArrayList<>();
        String index = "anmial";
        String type = "cat";
        Random random = new Random();

        String[] sexArray = new String[]{"公猫", "母猫"};
        String[] kindArray = new String[]{"虎斑猫", "黑足猫", "曼赤肯猫", "山东狮子猫", "四川简州猫", "中国云猫", "金吉拉", "红色重点色波斯猫", "红虎斑异国短毛猫", "阿比西尼亚猫", "爱琴猫", "澳大利亚雾猫",
                "美国多趾猫", "美国短尾猫", "美国卷耳猫", "美国卷毛猫", "美国短毛猫", "美国钢毛猫", "亚洲半长毛猫(蒂法尼猫", "蒂凡尼猫)", "巴厘猫(长毛暹罗猫", "长毛阿密丝猫)",
                "孟加拉猫(豹猫)", "阿比西尼亚猫", "埃及猫", "奥西猫", "伯曼猫", "布偶猫", "波斯猫", "德文卷毛猫", "电烫卷猫", "东方短毛猫", "东奇尼猫", "俄罗斯蓝猫", "哈瓦那棕猫",
                "加拿大无毛猫", "柯尼斯卷毛猫", "科拉特猫（呵叻猫）", "褴褛猫", "孟买猫", "缅甸猫", "缅因猫", "曼岛无尾猫",
                "挪威森林猫", "日本短尾猫", "斯可可猫", "索马里猫", "土耳其安哥拉猫", "土耳其梵猫", "夏特尔猫",
                "苏格兰折耳猫", "马恩岛猫"};
        String[] nameArray = new String[]{"拉面", "花花", "小白", "大白", "雪糕", "棉花", "白雪", "小墨", "小黑", "橙子", "黄黄", "大黄", "奶牛", "墨墨", "点点", "包子", "布丁", "奶昔", "奶酪", "小米", "大米", "Alice", "Amanda", "Amber", "Amy", "Andrea", "Angela", "Angle", "Anita", "Ann", "Anna", "Anne"};
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < 5000; i++) {
            DocMO docMO = new DocMO();
            docMO.setIndex(index);
            docMO.setType(type);
            String id = String.valueOf(i);
            docMO.setId(id);

            Cat cat = new Cat();
            cat.setId(id);
            cat.setAge(random.nextInt(30));
            cat.setSex(sexArray[random.nextInt(sexArray.length)]);
            cat.setKind(kindArray[random.nextInt(kindArray.length)]);
            cat.setName(nameArray[random.nextInt(nameArray.length)]);
            cat.setDesc(String.valueOf(random.nextInt(50000)));
            String json = "";
            try {
                json = objectMapper.writeValueAsString(cat);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            docMO.setJson(json);
            list.add(docMO);
        }
        service.bulkIndex(list);

    }
}
