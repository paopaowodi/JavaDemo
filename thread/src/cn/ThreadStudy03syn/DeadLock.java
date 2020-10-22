package cn.ThreadStudy03syn;

/**
 * @Author LiYun
 * @Date 2020/9/9 17:16
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1 = new MakeUp(0,"A");
        MakeUp girl2 = new MakeUp(2,"B");
        girl1.start();
        girl2.start();
    }
}

class LipStick{

}
class Mirror{

}
class MakeUp extends Thread{
    static LipStick stick = new LipStick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //名字
    String girl;
    public MakeUp(int choice,String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }
    //相互持有对方的对象锁 --> 可能造成死锁
    private void makeup(){
        if(choice == 0){
            synchronized (stick){  //获得口红的锁
                System.out.println(this.girl+"涂口红");
                //1s后想拥有镜子
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girl+"照镜子");
                }
            }
        }else{
            synchronized (mirror){  //获得镜子的锁
                System.out.println(this.girl+"照镜子");
                //2s后想拥有镜子
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (stick){
                    System.out.println(this.girl+"涂口红");
                }
            }

        }
    }
}