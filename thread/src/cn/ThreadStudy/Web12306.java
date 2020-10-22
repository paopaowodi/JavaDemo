package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 0:26
 * 共享资源,并发问题（线程安全）
 *
 */
public class Web12306 implements Runnable {
    private int ticketNums = 99;

    public static void main(String[] args) {
        //一份资源，多个代理
        Web12306 web = new Web12306();
        new Thread(web,"码农").start();
        new Thread(web,"mercy").start();
        new Thread(web,"码上").start();
    }

    @Override
    public void run() {
        while (true){
            if(ticketNums < 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
        }

    }
}
