package concurrent.threadpool;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author liu peng bo
 * @date 2018/12/11
 */
public class MyJob implements Runnable {
    private CountDownLatch countDownLatch;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public MyJob() {
    }

    public MyJob(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("begin " + Thread.currentThread().getName() + " " + new Date());
            Thread.sleep(2000);
            System.out.println("over" + " " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
