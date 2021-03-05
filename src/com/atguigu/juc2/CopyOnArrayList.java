package com.atguigu.juc2;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class CopyOnArrayList {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        //50个线程
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
    }
}
