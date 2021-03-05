package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //3个售票窗口  3个线程
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        },"A窗口").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        },"B窗口").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        },"C窗口").start();



    }
}

class Ticket{
    private int number = 20;//20张票
    private ReentrantLock lock = new ReentrantLock(true);
    public void sale(){
        lock.lock();//加锁
        try {
            if(number <= 0){
                System.out.println("手慢了，票已经卖完了");
                return;
            }
            Thread.sleep(20);
            number--;
            System.out.println(Thread.currentThread().getName()+"：卖了一张票，余票还有："+number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }
    public void b(){
        lock.lock();
        //b的业务逻辑代码处理完毕解锁
        lock.unlock();
    }



}
