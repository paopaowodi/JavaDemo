package test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author LiYun
 * @Date 2020/7/29 15:28
 * 解决线程安全问题的方式三：Lock锁  ---  JDK5.0新增
 */

class window implements Runnable{

    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {

                //2.调用锁定方法：lock()
                lock.lock();

                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                    ticket--;
                }else {
                    break;
                }
            } finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }

    }
}


public class LockTest {
    public static void main(String[] args) {
        window w = new window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
