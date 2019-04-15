package concurrent.lock.locksupport;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2018/12/9
 */
public class MyThread extends Thread {
    private String name;

    MyThread(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "开始执行!" + " " + new Date());
        FIFOLock.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FIFOLock.unLock();
        System.out.println(name + "执行结束!" + " " + new Date());

    }
}
