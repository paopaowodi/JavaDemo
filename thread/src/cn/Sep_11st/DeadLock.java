package cn.Sep_11st;

/**
 * @Author LiYun
 * @Date 2020/9/11 20:57
 * 死锁问题
 */
public class DeadLock {
    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        new Thread(()->{
            while(true){

                    try {
                        synchronized (LOCK_1){
                            System.out.println(Thread.currentThread().getName()+"锁住 lock1");
                            Thread.sleep(1000);
                            synchronized (LOCK_2){
                                System.out.println(Thread.currentThread().getName()+"锁住 lock2");
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }).start();

        new Thread(()->{

            try {
                synchronized (LOCK_2){
                    System.out.println(Thread.currentThread().getName()+"锁住 lock2");
                    Thread.sleep(1000);
                    synchronized (LOCK_1){
                        System.out.println(Thread.currentThread().getName()+"锁住 lock1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}