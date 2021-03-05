package com.atguigu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
public class ReentranReadWriteLockDemo {
    public static void main(String[] args) {


        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                myCache.write(Thread.currentThread().getName(),UUID.randomUUID().toString());
            },"Thread-"+i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                myCache.read(Thread.currentThread().getName());
            },"").start();
        }
    }
}
class MyCache{
    private volatile Map<String, String> map= new HashMap<>();
    // 加入读写锁
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void write(String key, String value){
        // 加写锁
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始写入！");
            Thread.sleep(50);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入成功！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放写锁
           rwl.writeLock().unlock();
        }
    }

    public void read(String key){
        // 加入读锁
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 开始读出！");
            Thread.sleep(10);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读出成功！" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放读锁
            rwl.readLock().unlock();
        }
    }
}
