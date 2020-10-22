package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 0:20
 *创建线程方式二：
 * 1.创建:实现Runnable + 重写 run
 *
 */
public class StartRun implements Runnable{
    public static void main(String[] args) {
//        //创建实现类对象
//        StartRun sr = new StartRun();
//        //创建代理类对象
//        Thread t = new Thread(sr);
//        //启动
//        t.start();
//
        new Thread(new StartRun()).start();
    }
    @Override
    public void run() {

    }
}
