package com.atguigu.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: jiangning
 * @Date: 2021/3/4
 */
public class NotSafeDemo1 {
    public static void main(String[] args) {
       //Set<String> set = new HashSet<>();//线程不安全java.util.ConcurrentModificationException
        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            },"").start();
        }
    }
}
