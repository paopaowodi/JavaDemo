package cn.sellTicket;

/**
 * @Author LiYun
 * @Date 2020/7/28 8:52
 * 创建三个窗口卖票，总票数100张，使用实现Runnable接口的方式
 *
 * 问题：卖票过程中出现了重票、错票  ---->线程的安全问题
 * 出现原因：当某个线程操作车票过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 如何解决:当一个线程a在操作车票时，其他线程不能参与进来，直到线程a结束为止
 * 在Java中，通过同步机制来解决线程的安全问题
 *
 *
 */

class window1 implements Runnable{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            synchronized (windowTest.class){
                if(ticket > 0 ){
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}


public class windowTest1 {
    public static void main(String[] args) {
         window1 w = new window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
