package concurrent.threadlocal;

/**
 * @author liu peng bo
 * @date 2018/12/20
 */
public class TestTl {
    public static void main(String[] args) throws InterruptedException {
        /*MyTlThread tlThread = new MyTlThread();
        tlThread.start();
        tlThread.join();*/
        System.out.println(MyThreadLocal.tl.get());

        MyThreadLocal.tl.set(2);
        System.out.println(MyThreadLocal.tl.get());
    }
}
