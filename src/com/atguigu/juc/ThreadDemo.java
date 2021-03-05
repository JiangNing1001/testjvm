package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("这是主线程： "+ Thread.currentThread().getName());
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("这是通集成Thread类的多线程的程序:"+Thread.currentThread().getName());
    }
}