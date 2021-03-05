package com.atguigu.juc2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet();
        //50个线程
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            }).start();
        }
    }
}
