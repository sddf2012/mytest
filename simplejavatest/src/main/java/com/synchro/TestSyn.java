package com.synchro;

/**
 * @author liu peng bo
 * @date 2018/10/11
 */
class Syn {
    public synchronized void s1() {
        try {
            System.out.println("s1 begin");
            Thread.sleep(6000);
            System.out.println("s1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void s2() {
        try {
            System.out.println("s2 begin");
            Thread.sleep(3000);
            System.out.println("s2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadSyn extends Thread {
    private Syn syn;

    public ThreadSyn(Syn syn) {
        this.syn = syn;
    }

    @Override
    public void run() {
        syn.s2();
    }
}

public class TestSyn {
    public static void main(String[] args) {
        Syn s1 = new Syn();
        ThreadSyn threadSyn = new ThreadSyn(s1);
        threadSyn.start();
        s1.s1();
    }
}
