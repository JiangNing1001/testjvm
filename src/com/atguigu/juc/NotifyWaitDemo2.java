package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
//需求：两个线程操作一个初始值为0的变量，实现一个线程对变量增加1，一个线程对变量减少1，交替10轮。


public class NotifyWaitDemo2 {
    public static void main(String[] args) {
        ShareDateOne shareDateOne = new ShareDateOne();
        //2个线程
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDateOne.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDateOne.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDateOne.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CCC").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDateOne.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"DDD").start();
    }
}
class ShareDateOne2 {
    private int number = 0;


    Lock l = new ReentrantLock();
    Condition condition = l.newCondition();
    public  void incr() throws InterruptedException {

        l.lock();
        //1判断
        if(number!=0){
            condition.await();
        }
        //2干活
        number++;
        System.out.println(Thread.currentThread().getName()+": "+number);
        //3通知
        l.unlock();
    }

    public  void decr() throws InterruptedException {
        l.lock();
        //1判断
        if(number!=1){
            condition.await();
        }
        //2干活
        number--;
        System.out.println(Thread.currentThread().getName()+": "+number);
        //3通知
        l.unlock();
    }
}
