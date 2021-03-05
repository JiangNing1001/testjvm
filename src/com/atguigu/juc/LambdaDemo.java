package com.atguigu.juc;

/**
 * @Author: jiangning
 * @Date: 2021/3/3
 */
//@FunctionalInterface//强制要求该接口内只有一个接口

//Foo一个例子的意思
@FunctionalInterface
interface Foo{
    public int add(int a ,int b);
    default int decr(int a,int b){
        return a - b;
    };
    public static int mult(int a,int b){
        return a * b;
    };

}
public class LambdaDemo {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        System.out.println(foo.add(2,2));

        Foo foo1 = (a,b)->a+b;
        System.out.println(foo.add(2,2));
        //------------------
        System.out.println( foo.decr(2,2) );
        System.out.println(Foo.mult(2,2));//静态方法使用哪个类dia调用
    }
}
