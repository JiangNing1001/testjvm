package com.atguigu.juc3;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */

public class VolatileDemo {
    private volatile static int number = 1 ;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程读取的number的初始值是"+number);
        new Thread(()->{
            System.out.println("子线程读取number的初始值是"+number);
            while(number == 1){
            }
            System.out.println("子线程读取的number的最新值是"+number);
        },"").start();
        Thread.sleep(200);
        number = 2;
        System.out.println("主线程读取的number的最新值是"+number);
    }
}
