package concurrent.lock.locksupport;

/**
 * @author liu peng bo
 * @date 2018/12/9
 */
public class TestLs {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();

    }

}
