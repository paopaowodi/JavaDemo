package test1;

/**
 * @Author LiYun
 * @Date 2020/7/29 9:36
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {
}

class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                instance = new Bank();
                }
            }
        }
            return instance;
        }

}
