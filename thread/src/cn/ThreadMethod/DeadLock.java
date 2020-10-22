package cn.ThreadMethod;

/**
 * @Author LiYun
 * @Date 2020/7/31 8:41
 * 测试死锁
 */
public class DeadLock {
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread("线程A"){
            @Override
            public void run() {
                while (true) {
                    synchronized (o1){
                        System.out.println(getName()+"正在使用o1,等待o2");
                        synchronized (o2){
                            System.out.println(getName()+"等待o2,执行成功");
                        }
                    }
                }
            }
        }.start();

        new Thread("线程B"){
            @Override
            public void run() {
                while(true){
                    synchronized (o2){
                        System.out.println(getName()+"正在使用o2,等待o1");
                        synchronized (o1){
                            System.out.println(getName()+"等待o1,执行成功");
                        }
                    }
                }
            }
        }.start();
    }
}
