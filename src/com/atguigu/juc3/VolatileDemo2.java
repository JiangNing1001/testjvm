package com.atguigu.juc3;

/**
 * @Author: jiangning
 * @Date: 2021/3/5
 */

//volatile 的有序性
public class VolatileDemo2 {
    public static volatile int a,b;
    public static int x,y;

    public static void main(String[] args) throws InterruptedException {
        int i = 0 ;
        while(true){
            i++;
            a = b = 0;
            Thread thread1 = new Thread(()->{
                a = 1;
                x = b ;
            },"");
            Thread thread2 = new Thread(()->{
                b = 1;
                y = a;
            },"");
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("第"+i+"次的打印的结果为"+"x="+x+"   y="+y);
            if(x==0 && y==0){
                break;
            }
        }

    }
}
/**
 * 3种情况
 *  a = b = 0;
 * 第一种：线程1先执行  线程2执行
 *         结果：x=0  y=1
 * 第二种：线程2先执行   线程1执行
 *         结果：x=1   y=0
 *  第三种：并发情况下
 *     a = 1; b = 1;  x = b ;y = a;
 *         结果：x=1 y=1
 *  第四种：x = b ; y = a; a = 1;b = 1;如果出现就是执行重排
 *     结果：x=0  y=0
 */
