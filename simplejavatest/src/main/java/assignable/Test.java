package assignable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2019/2/12
 */
public class Test {
    public static void main(String[] args) {
        byte a=(byte)1;
        Byte b=1;
        System.out.println(a==b);
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
    }
}
