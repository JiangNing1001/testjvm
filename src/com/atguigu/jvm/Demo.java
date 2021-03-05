package com.atguigu.jvm;

/**
 * @Author: jiangning
 * @Date: 2021/3/2
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("===============begin=============");
        System.out.println("最大可扩展大小： "+Runtime.getRuntime().maxMemory()/1024/1024);//堆的最大值，默认是内存的1/4
        System.out.println("当前堆大小： "+Runtime.getRuntime().totalMemory()/1024/1024);// 堆的当前总大小，默认是内存的1/64
        System.out.println("堆的剩余大小： "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("=============first===============");
        byte[] b1 = new byte[5 * 1024 * 1024];
        System.out.println("最大可扩展大小： "+Runtime.getRuntime().maxMemory()/1024/1024);//堆的最大值，默认是内存的1/4
        System.out.println("当前堆大小： "+Runtime.getRuntime().totalMemory()/1024/1024);// 堆的当前总大小，默认是内存的1/64
        System.out.println("堆的剩余大小： "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("=============second===============");
        byte[] b2 = new byte[10 * 1024 * 1024];
        System.out.println("最大可扩展大小： "+Runtime.getRuntime().maxMemory()/1024/1024);//堆的最大值，默认是内存的1/4
        System.out.println("当前堆大小： "+Runtime.getRuntime().totalMemory()/1024/1024);// 堆的当前总大小，默认是内存的1/64
        System.out.println("堆的剩余大小： "+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("=============OOM===============");
        byte[] b3 = new byte[40 * 1024 * 1024];
        System.out.println("最大可扩展大小： "+Runtime.getRuntime().maxMemory()/1024/1024);//堆的最大值，默认是内存的1/4
        System.out.println("当前堆大小： "+Runtime.getRuntime().totalMemory()/1024/1024);// 堆的当前总大小，默认是内存的1/64
        System.out.println("堆的剩余大小： "+Runtime.getRuntime().freeMemory()/1024/1024);
    }
}
