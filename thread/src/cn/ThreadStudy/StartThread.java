package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 0:03
 * 线程创建方式一：
 * 创建:继承Thread
 */
public class StartThread extends Thread{
    /**
     * 线程入口点
     * */

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {

        StartThread st = new StartThread();
        st.start();
//        st.run(); //普通方法调用

        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }

    }
}
