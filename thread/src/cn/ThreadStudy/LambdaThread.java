package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 17:41
 * Lambda表达式 简化线程 (用一次且简单)的使用
 */
public class LambdaThread {
    //静态内部类
    static class Test implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
        //lambda表达式
        new Thread(()->{
            //run方法
        }

        ).start();
    }
}
