package exceptiontest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liu peng bo
 * @date 2019/3/5
 */
public class TryWithEx {
    public static void main(String[] args) {
        try ( InputStream i = new ByteArrayInputStream("hello".getBytes());
              InputStream j = new ByteArrayInputStream("hello".getBytes())) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
