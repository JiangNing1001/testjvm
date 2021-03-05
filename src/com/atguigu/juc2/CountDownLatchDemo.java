package com.atguigu.juc2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //A同学
            Thread thread1 = new Thread(()->{
                try {
                    System.out.println("A同学"+Thread.currentThread().getName()+"要出门了。。。");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));//出门前墨迹5
                    System.out.println("A同学"+Thread.currentThread().getName()+"出门了。。。");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A同学");
        //B同学
        Thread thread2 = new Thread(()->{
            try {
                System.out.println("B同学"+Thread.currentThread().getName()+"要出门了。。。");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));//出门前墨迹5
                System.out.println("B同学"+Thread.currentThread().getName()+"出门了。。。");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B同学");
        //C同学
        Thread thread3 = new Thread(()->{
            try {
                System.out.println("C同学"+Thread.currentThread().getName()+"要出门了。。。");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));//出门前墨迹5
                System.out.println("C同学"+Thread.currentThread().getName()+"出门了。。。");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C同学");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("班长锁门。。。");
    }
}
