package cn.ThreadMethod;

/**
 * @Author LiYun
 * @Date 2020/7/27 16:54
 * 测试Thread中的常用方法
 */

class OKThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            if(i % 2 == 0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {    //父类没有抛异常，子类不能抛
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        OKThread o1 = new OKThread();

        o1.setName("线程一");
        o1.setPriority(Thread.MAX_PRIORITY);

        o1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i <100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
            if( i == 20){
                try {
                    o1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
