package cn.sellTicket;

/**
 * @Author LiYun
 * @Date 2020/7/29 9:20
 * 使用同步方法处理继承 Thread类的方式中的线程安全问题
 *
 */

class windowPlus extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
          show();

        }
    }
    private static synchronized void show(){
   // private synchronized void show(){ //同步监视器t1,t2,t3,这种方式是错误的
            if(ticket > 0 ){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ ticket);
                ticket--;
            }

    }
}
public class windowTestPlus {
    public static void main(String[] args) {

        windowPlus t1 = new windowPlus();
        windowPlus t2 = new windowPlus();
        windowPlus t3 = new windowPlus();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
