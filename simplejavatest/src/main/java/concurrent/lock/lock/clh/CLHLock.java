package concurrent.lock.lock.clh;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liu peng bo
 * @date 2018/12/13
 */
public class CLHLock {


    private class Node {
        private boolean lock;
    }

    private ThreadLocal<Node> current;
    private ThreadLocal<Node> pre;
    private AtomicReference<Node> tail;


    public CLHLock() {
        current = ThreadLocal.withInitial(Node::new);
        pre = ThreadLocal.withInitial(() -> null);
        this.tail = new AtomicReference<>(new Node());
    }

    public void lock() {
        current.get().lock = true;
        Node preNode = tail.getAndSet(current.get());
        pre.set(preNode);
        while (preNode.lock) {

        }
    }


    public void unlock() {
        current.get().lock = false;
        current.set(pre.get());
    }

    public static void main(String[] args) {
        CLHLock lock = new CLHLock();
        CLHJob job1 = new CLHJob(lock);
        CLHJob job2 = new CLHJob(lock);
        job1.start();
        job2.start();
    }


}
