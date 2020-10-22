package cn.ThreadStudy03syn;

/**
 * @Author LiYun
 * @Date 2020/9/8 21:25
 * 线程不安全
 */
public class UnSafeTest01 {
    public static void main(String[] args) {
        UnsafeWeb12306 ticket = new UnsafeWeb12306();
        new Thread(ticket,"一").start();
        new Thread(ticket,"二").start();
        new Thread(ticket,"三").start();

    }
    static class UnsafeWeb12306 implements Runnable{
        private int ticketNums = 10;
        private boolean flag = true;

        @Override
        public void run() {
            while (flag){
                test();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
            }
        }
        public void test (){
            if(ticketNums < 0){
                flag = false;
                return;
            }
        }
    }
}

//class UnsafeWeb12306 implements Runnable{
//    private int ticketNums = 99;
//    private boolean flag = true;
//
//    @Override
//    public void run() {
//        while (flag){
//            test();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
//        }
//    }
//    public void test (){
//        if(ticketNums < 0){
//            flag = false;
//            return;
//        }
//    }
//}