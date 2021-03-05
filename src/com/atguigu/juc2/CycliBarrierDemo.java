package com.atguigu.juc2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class CycliBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Thread(new MyRunable()));

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"第一关开始了。。。");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+"第一关打完了。。。");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"第二关开始了。。。");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+"第二关打完了。。。");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"第三关开始了。。。");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+"第三关打完了。。。");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
class MyRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("恭喜你通关了");
    }
}
