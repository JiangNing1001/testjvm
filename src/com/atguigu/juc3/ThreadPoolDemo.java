package com.atguigu.juc3;


import java.util.concurrent.*;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //参数1：线程池中的常驻核心线程数  参数2：线程池中能够容纳同时 执行的最大线程数
        //参数3：多余的空闲线程的存活时间  参数5：队列大小
        ExecutorService executorService = new ThreadPoolExecutor(3,5,60, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),);
        //5个任务
        for (int i = 0; i < 20; i++) {
            int FinalI = i ;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"执行了一个任务"+FinalI);
            });
        }
        executorService.shutdown();
    }
}
/**
 * 当有5个任务  3个线程池来回使用
 * 当有15个任务  处理不过来  开始扩展线程池
 * 当有150个任务，异常出现java.util.concurrent.RejectedExecutionException
 * //引出了拒绝策略
 */
