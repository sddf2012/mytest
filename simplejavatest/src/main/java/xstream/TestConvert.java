package xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/10/15 17:15
 */
public class TestConvert {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","chris");
        map.put("island","faranga");

// convert to XML
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("map", java.util.Map.class);
        String xml = xStream.toXML(map);

// from XML, convert back to map
        Map<String,Object> map2 = (Map<String,Object>) xStream.fromXML(xml);
        System.out.println(11);
    }
}
