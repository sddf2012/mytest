package com.future;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liu peng bo
 * @date 2018/6/4
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(new Date());
        /*Callable call=new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        }*/
        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable"+new Date());
            }
        };
        FutureTask future=new FutureTask(runnable,1);
        new Thread(future).start();
        //future.run();
        Thread.sleep(1000);
        System.out.println("其他程序执行!"+new Date());
        System.out.println(future.get());
        //Executors
    }
}
