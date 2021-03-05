package com.atguigu.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
//初始化一个子任务，以便于将来的某个时刻获取任务的返回结果集，通长就用于多线程的异步任务
public class CallableDemo2 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        //可以通过FutureTask的get()方法阻塞获取返回结果集，get()方法尽量放在靠后的位置，让主线程处理更多的业务
        new Thread(futureTask).start();//FutureTask<>相当于桥梁
        try {
            System.out.println(futureTask.get());
            System.out.println("这是主线程的输出");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class MyCallable2 implements Callable<String>{
    @Override
    public String call() {
        System.out.println("这是通过Callable方式初始化了多线程的程序");
        int i = 1/0;
        return "hello callable..";//子任务的返回结果集
    }
}

