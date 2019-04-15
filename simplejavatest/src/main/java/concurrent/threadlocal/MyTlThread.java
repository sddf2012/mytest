package concurrent.threadlocal;

/**
 * @author liu peng bo
 * @date 2018/12/20
 */
public class MyTlThread extends Thread {
    @Override
    public void run() {
        MyThreadLocal.tl.set(1);
        System.out.println(MyThreadLocal.tl.get());
    }
}
