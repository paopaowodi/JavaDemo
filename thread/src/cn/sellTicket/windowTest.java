package cn.sellTicket;

/**
 * @Author LiYun
 * @Date 2020/7/27 20:23
 * 创建三个窗口卖票，总票数100张，继承于Thread类
 *
 */
class window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            synchronized (windowTest.class){
            if(ticket > 0 ){
                System.out.println(getName()+":卖票，票号为："+ ticket);
                ticket--;
            }else{
                break;
            }
            }
        }
    }
}



public class windowTest {
    public static void main(String[] args) {

        window t1 = new window();
        window t2 = new window();
        window t3 = new window();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
