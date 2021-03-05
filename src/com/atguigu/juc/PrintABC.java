package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 案例：
 *
 * ​多线程之间按顺序调用，实现A->B->C。三个线程启动，要求如下：
 * ​AA打印5次，BB打印10次，CC打印15次
 */
class Print{
    private int flag = 1;

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    public void printA() throws InterruptedException {
        lock.lock();
        if(flag !=1 ){
            c1.await();
        }
        System.out.println("AAAAA");
        flag = 2;
        c2.signalAll();
        lock.unlock();
    }
    public void printB() throws InterruptedException {
        lock.lock();
        if(flag!=2){
            c2.await();
        }
        System.out.println("BBBBBBBBBB");
        flag = 3;
        c3.signalAll();
        lock.unlock();
    }

    public void printC() throws InterruptedException {
        lock.lock();
        if(flag!=3){
            c3.await();
        }
        System.out.println("CCCCCCCCCCCCCCC");
        flag =1;
        c1.signalAll();
        lock.unlock();
    }
}
public class PrintABC {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    print.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    print.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    print.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
    }
}
