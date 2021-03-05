package com.atguigu.juc3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class CallacleDemo {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
            System.out.println("这是主线程的输出");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("这是通过callable的方式初始化了多线程");
        int i = 1/0;
        return "helloworld";
    }
}
