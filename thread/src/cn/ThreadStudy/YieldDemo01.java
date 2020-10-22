package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 20:38
 * yield礼让线程，暂停线程
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my,"a").start();
        new Thread(my,"b").start();

    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "--->start");
        Thread.yield();  //礼让
        System.out.println(Thread.currentThread().getName()+ "--->end");

    }
}