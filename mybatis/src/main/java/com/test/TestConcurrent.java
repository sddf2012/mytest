package com.test;

import com.service.TestService;
import com.service.impl.TestServiceImpl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liu peng bo
 * @date 2019/4/11
 */
public class TestConcurrent {
    static class MyThread extends Thread {
        TestService testService;
        int id;
        int type;
        int result = 0;
        CountDownLatch countDownLatch;

        public MyThread(TestService testService, int type, int id,CountDownLatch countDownLatch) {
            this.testService = testService;
            this.type = type;
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            switch (type) {
                case 1:
                    result = testService.updateAIncr(id);
                    break;
                case 2:
                    result = testService.updateA(id);
                    break;
                case 3:
                    result = testService.updateAVersion(id);
                    break;
                case 4:
                    result = testService.selectAForUpdate(id);
                    break;
                default:
                    break;
            }
            countDownLatch.countDown();
        }

        public int getResult() {
            return result;
        }
    }
    static int num=110;
    static ExecutorService service = Executors.newFixedThreadPool(200);
    static TestService testService = new TestServiceImpl();

    static void test1() throws InterruptedException {
        testService.update(1);
        CountDownLatch countDownLatch=new    CountDownLatch(num);
        MyThread[] myThreads = new MyThread[num];
        for (int i = 0; i < num; i++) {
            MyThread myThread = new MyThread(testService, 1, 1,countDownLatch);
            myThreads[i] = myThread;
        }
        for (MyThread myThread : myThreads) {
            service.submit(myThread);
        }
        countDownLatch.await();
        System.out.println("test1 result:"+testService.selectById(1).getA());
        Thread.sleep(1000);
    }
    static void test2() throws InterruptedException {
        testService.update(2);

        CountDownLatch countDownLatch=new    CountDownLatch(num);
        MyThread[] myThreads = new MyThread[num];
        for (int i = 0; i < num; i++) {
            MyThread myThread = new MyThread(testService, 2, 2,countDownLatch);
            myThreads[i] = myThread;
        }
        for (MyThread myThread : myThreads) {
            service.submit(myThread);
        }
        countDownLatch.await();
        System.out.println("test2 result:"+testService.selectById(2).getA());
    }
    static void test3() throws InterruptedException {
        testService.update(3);

        CountDownLatch countDownLatch=new    CountDownLatch(num);
        MyThread[] myThreads = new MyThread[num];
        for (int i = 0; i < num; i++) {
            MyThread myThread = new MyThread(testService, 3, 3,countDownLatch);
            myThreads[i] = myThread;
        }
        for (MyThread myThread : myThreads) {
            service.submit(myThread);
        }
        countDownLatch.await();
        System.out.println("test3 result:"+testService.selectById(3).getA());
    }
    static void test4() throws InterruptedException {
        testService.update(4);

        CountDownLatch countDownLatch=new    CountDownLatch(num);
        MyThread[] myThreads = new MyThread[num];
        for (int i = 0; i < num; i++) {
            MyThread myThread = new MyThread(testService, 4, 4,countDownLatch);
            myThreads[i] = myThread;
        }
        for (MyThread myThread : myThreads) {
            service.submit(myThread);
        }
        countDownLatch.await();
        System.out.println("test4 result:"+testService.selectById(4).getA());
    }

    public static void main(String[] args) throws InterruptedException {
        TestConcurrent.test1();
        //TestConcurrent.test2();
        //TestConcurrent.test3();
       //TestConcurrent.test4();
       // Thread.sleep(1000);
    }
}
