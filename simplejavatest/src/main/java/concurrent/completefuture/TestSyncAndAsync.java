package concurrent.completefuture;

import io.netty.util.concurrent.CompleteFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/13 14:03
 */
public class TestSyncAndAsync {
    public static void main(String[] args) {
        CompletableFuture<String> cf=CompletableFuture.completedFuture("complete");
        System.out.println(System.currentTimeMillis());
        Function f=s-> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s+" function";};
        System.out.println(cf.thenApply(f).join());
        System.out.println("1232");
    }
}
