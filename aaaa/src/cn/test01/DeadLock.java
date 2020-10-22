package cn.test01;

import javax.xml.transform.OutputKeys;

/**
 * @Author LiYun
 * @Date 2020/9/13 19:10
 * 死锁
 */
public class DeadLock {
    static String s1 = "abc";
    static String s2 = "bcd";
    public static void main(String[] args) {
         new Thread(()->{
            synchronized (s1){
                System.out.println("s1");
                try {
                    s1.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2){
                    System.out.println("s2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (s2){
                System.out.println("s2");
                try {
                    s2.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1){
                    System.out.println("s1");
                }
            }
        }).start();
    }

}
