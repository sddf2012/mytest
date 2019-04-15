package gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2019/1/23
 */
class Memory {
    private byte[] a = new byte[64 * 1024];
}

public class Test1 {
    static void test(int i) throws InterruptedException {
        List<Memory> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(new Memory());
            Thread.sleep(50);
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        test(1000);
        Thread.sleep(10000);
    }
}
