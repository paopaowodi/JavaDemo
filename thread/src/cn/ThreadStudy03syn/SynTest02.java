package cn.ThreadStudy03syn;

/**
 * @Author LiYun
 * @Date 2020/9/8 21:47
 * 线程安全:取钱
 */
public class SynTest02 {
    public static void main(String[] args) {
        Account account = new Account(100,"钱");
        safeDrawing you = new safeDrawing(account,80,"A");
        safeDrawing he = new safeDrawing(account,70,"B");
        you.start();
        he.start();

    }
}
//取款
class safeDrawing extends Thread{
    Account account;  //取钱的账户
    int drawingMoney;
    int packetTotal;

    public safeDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }
    public synchronized void test(){
        if(account.money-drawingMoney< 0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName()+"-->账户余额为:"+account.money);
        System.out.println(this.getName()+"-->口袋的钱为:"+packetTotal);

    }
}

