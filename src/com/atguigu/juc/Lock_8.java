package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

//资源类
class Phone {
    //加锁-发送短信的方法
    public static synchronized void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(4);//停4秒在短信方法内
        System.out.println("------sendSMS");
    }
    //加锁-发送邮件的方法
    public synchronized void sendEmail() throws Exception {
        System.out.println("------sendEmail");
    }
//    //普通hello方法
//    public void getHello() {
//        synchronized (a){
//            System.out.println("------getHello");
//        }
//    }

}

public class Lock_8 {

    public static void main(String[] args) throws Exception {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(100);//如果没有睡这个，就不知道谁先打

        new Thread(() -> {
            try {
             //phone.sendEmail();
            // phone.getHello();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}