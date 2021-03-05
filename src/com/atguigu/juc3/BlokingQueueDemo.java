package com.atguigu.juc3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class BlokingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String>  queue = new ArrayBlockingQueue<String>(3);//队列大小

        queue.put("a");
        queue.put("b");
        queue.put("c");
        //多出队也会阻塞
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
