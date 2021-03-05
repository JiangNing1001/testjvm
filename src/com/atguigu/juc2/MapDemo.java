package com.atguigu.juc2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */
public class MapDemo {
    public static void main(String[] args) {
        //java.util.concurrent包下
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
                System.out.println(map);
            },"").start();
        }
    }
}
