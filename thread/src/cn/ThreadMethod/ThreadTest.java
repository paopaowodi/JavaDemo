package cn.ThreadMethod;

/**
 * @Author LiYun
 * @Date 2020/7/27 11:08
 * 多线程的创建,方式一：继承于 Thread 类
 *  1.创建一个继承于Thread类的子类
 *  2.重写 Thread类的run() -->将此线程执行的操作声明在run()中
 *  3.创建 Thread类的子类的对象
 *  4.通过此对象调用start()
 *
 *  例子:遍历100以内的所有偶数
 */

//1.创建一个继承于Thread类的子类
    class MyThread extends Thread{
        // 2.重写 Thread类的run()
    @Override
    public void run() {
       for(int i = 0; i < 100; i++){
           if(i % 2 == 0){
               System.out.println(i);
           }
       }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3.创建 Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start() 启动当前线程
        t1.start();
        //main线程中
        System.out.println("hello");
    }

}
