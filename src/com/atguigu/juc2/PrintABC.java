package com.atguigu.juc2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public class PrintABC {
    public static void main(String[] args) {
        DateADC dateADC = new DateADC();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    dateADC.printA();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    dateADC.printB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    dateADC.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
    }
}
class DateADC{
    private int flag = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    public void printA() throws InterruptedException {
        lock.lock();
        if(flag!=1){
            c1.await();
        }
        System.out.println("AA打印5次");
        c2.signalAll();
        lock.unlock();
    }
    public void printB() throws InterruptedException {
        lock.lock();
        if(flag!=2){
            c2.await();
        }
        System.out.println("BB打印了10次");
        c3.signalAll();
        lock.unlock();
    }
    public void printC() throws InterruptedException {
        lock.lock();
        if(flag!=3){
            c3.await();
        }
        System.out.println("CCC打印了15次");
        c1.signalAll();
        lock.unlock();
    }
}
