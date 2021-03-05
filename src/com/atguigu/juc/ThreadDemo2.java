package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //口诀：拷贝小括号-写死右箭头-落地大括号
        new Thread(()->{
            System.out.println("这是通过实现Runable接口实现了接口的多线程"+Thread.currentThread().getName());
        }).start();
        System.out.println("这时主线程"+Thread.currentThread().getName());
    }
}
//内部类
//class MyRunable implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("这是通过实现Runable接口实现了接口的多线程"+Thread.currentThread().getName());
//    }
//}
