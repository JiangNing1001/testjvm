package com.atguigu.juc4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: jiangning
 * @Date: 2021/3/6
 */
public class CasDemo {
    public static void main(String[] args) throws InterruptedException {
        DataTwo dataTwo = new DataTwo();
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                dataTwo.incr();
                latch.countDown();
            }).start();
            latch.await();
            System.out.println(dataTwo.number.get());
        }
    }
}
class DataTwo{
    AtomicInteger number = new AtomicInteger(0);

    public void incr(){
      number.incrementAndGet();
    }
}
