package stringformat;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/28 16:05
 */
public class TestFormat {
    static Logger logger= LoggerFactory.getLogger(TestFormat.class);
    public static void main(String[] args) {
       String a= MessageFormat.format("123{0}","qwe");
        logger.error("123{%s},{}","q","2");
        System.out.println(a);
        System.out.println(String.format("大家好，我叫：%s","小明"));
        logger.info("123",4,5);
    }
}
