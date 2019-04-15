package concurrent.lock.lock.clh;

/**
 * @author liu peng bo
 * @date 2018/12/14
 */
public class CLHJob extends Thread{
    private CLHLock lock;

    public CLHJob(CLHLock lock) {
        this.lock = lock;
    }

    @Override
    public void run(){
        String name=Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            lock.lock();
            System.out.println(name+" get lock!");
            lock.unlock();
            System.out.println(name+" release lock!");
        }

    }
}
