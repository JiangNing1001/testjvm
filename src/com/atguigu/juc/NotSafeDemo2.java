package com.atguigu.juc;

import java.util.*;

/**
 * @Author: jiangning
 * @Date: 2021/3/4
 */
public class NotSafeDemo2 {
    public static void main(String[] args) {
       //Map<String,String> map = new HashMap<>();// java.util.ConcurrentModificationException
        //Map<String,String> map = Collections.synchronizedMap(new )
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
//                map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString());
//                System.out.println(map);
            },"").start();
        }
    }
}
