package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
//需求：两个线程操作一个初始值为0的变量，实现一个线程对变量增加1，一个线程对变量减少1，交替10轮。
class ShareDateOne {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        //1判断
        while (number!=0){
            this.wait();
        }
        //2干活
        number++;
        System.out.println(Thread.currentThread().getName()+": "+number);
        //3通知
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        //1判断
        while (number!=1){
            this.wait();
        }
        //2干活
        number--;
        System.out.println(Thread.currentThread().getName()+": "+number);
        //3通知
        this.notifyAll();
    }
}
public class NotifyWaitDemo {
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
