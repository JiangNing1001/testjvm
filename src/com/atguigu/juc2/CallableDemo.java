package com.atguigu.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class CallableDemo {
    public static void main(String[] args) {
        //new Thread(new MyCallable()).start();不可以
        new Thread( new FutureTask<>(new MyCallable())).start();//FutureTask<>相当于桥梁
        System.out.println("这是主线程的输出");
    }
}
class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("这是通过Callable方式初始化了多线程的程序");
        return "hello callable..";
    }
}
