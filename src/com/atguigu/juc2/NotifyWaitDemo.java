package com.atguigu.juc2;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public  class NotifyWaitDemo {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDate.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    shareDate.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
class ShareDate{
    private int number = 0;
    public synchronized  void add() throws InterruptedException {
            //判断
            if(number!=0){
                this.wait();
            }
            //干活
            number ++ ;
        System.out.println(Thread.currentThread().getName()+":"+number);
            //通知
            this.notify();
    }
    public synchronized void decr() throws InterruptedException {
            //判断
            if(number!=1){
                this.wait();
            }
            //干活
            number -- ;
        System.out.println(Thread.currentThread().getName()+":"+number);
            //通知
            this.notify();
    }
}
