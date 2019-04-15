package concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class MyCallableJob implements Callable<Integer> {
    @Override
    public Integer call() {
        return new Random().nextInt();
    }
}
