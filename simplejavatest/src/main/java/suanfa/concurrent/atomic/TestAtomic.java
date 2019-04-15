package suanfa.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu peng bo
 * @date 2018/12/7
 */
public class TestAtomic {
    private int a = 1;

    private int b = 1;

    private void old() {
        //Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });

        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
    }
}
