package cn.homework;

/**
 * @Author LiYun
 * @Date 2020/7/28 9:13
 * @Version 1.0
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadWork {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
