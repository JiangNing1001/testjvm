package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/4
 */
public class Print1_52 {
    public static void main(String[] args) {
        //资源类的对象
        PringNumAndEng print = new PringNumAndEng();

        //线程1打印：1-52  每一次打印2个数字   52/2=26次
        new Thread(()->{
            try {
                for (int i = 0; i < 26; i++) {
                    print.printNum();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
        //线程2打印：A-Z  每一次打印1个字母  26/1=26次
        new Thread(()->{
            try {
                for (int i = 0; i < 26; i++) {
                    print.PrintEng();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"").start();
    }
}
class PringNumAndEng{

    private int number1 = 1;  //初始化数字1
    private int number2 = 2;
    private int count1 = 0;  //打印个数2
    //初始化字母A
    private int Eng = 1;//A的ASCLL码65  z-90
    private  int count2 =0;
    //此方法打印数字
    public synchronized void printNum() throws InterruptedException {
        //判断
        while(count1==2){
            this.wait();
        }
        //干活
        System.out.print(number1);count1++;
        System.out.print(number2);count1++;
        count2=0;
        //通知
        this.notify();
    }
    //此方法打印字母
    public synchronized void PrintEng() throws InterruptedException {
        //判断
        while(count2==1){
            this.wait();
        }
        //干活
        System.out.print( String.valueOf((char)(Eng + 64)) );count2++;Eng++;
        count1=0;
        number1+=2;
        number2+=2;
        //通知
        this.notify();
    }
}

