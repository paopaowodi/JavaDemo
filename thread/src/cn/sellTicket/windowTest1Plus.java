package cn.sellTicket;

/**
 * @Author LiYun
 * @Date 2020/7/29 9:03
 * @Version 1.0
 */


class window1Plus implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(ticket>0){
            show();
        }
    }
    private synchronized void show(){  //同步监视器：this
        if(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
            ticket--;
        }
    }
}


public class windowTest1Plus {
    public static void main(String[] args) {
        window1Plus w = new window1Plus();
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
