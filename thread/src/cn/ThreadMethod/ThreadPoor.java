package cn.ThreadMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author LiYun
 * @Date 2020/7/31 8:24
 * 创建线程的方式四：使用线程池
 */

class OkThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadPoor {
    public static void main(String[] args) {
       //1.提供指定线程数量的线程池
        ExecutorService ser = Executors.newFixedThreadPool(10);

      //设置线程池的属性
        System.out.println(ser.getClass());


       //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        ser.execute(new OkThread());//适合适用于Runnable
        //ser.submit(Callable callable);//适合适用于Callable
        //3.关闭线程池
        ser.shutdown();
    }
}
