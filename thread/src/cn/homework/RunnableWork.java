package cn.homework;

/**
 * @Author LiYun
 * @Date 2020/7/28 9:16
 * @Version 1.0
 */

class AThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class RunnableWork {
    public static void main(String[] args) {
        AThread m = new AThread();
        Thread t1 = new Thread(m);
        t1.start();
    }
}
