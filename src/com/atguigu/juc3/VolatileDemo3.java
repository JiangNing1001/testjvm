package com.atguigu.juc3;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */

//volatile 的原子性相关
public class VolatileDemo3 {
    public static void main(String[] args) throws InterruptedException {
        DateOne dateOne = new DateOne();

        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                dateOne.incr();
                latch.countDown();
            },"").start();
        }
        latch.await();
        System.out.println("number的最终值是:  "+dateOne.number);
    }
}

class DateOne{
    int number = 0;
    public synchronized void incr(){
        number++;
    }
}
