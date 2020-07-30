package cn.homework;

/**
 * @Author LiYun
 * @Date 2020/7/29 15:46
 *
 * 问题描述：银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 */
class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance += amt;
            System.out.println(Thread.currentThread().getName()+"存钱成功。余额为："+ balance);
        }
    }
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class BankTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("李狗蛋");
        c2.setName("王小花");

        c1.start();
        c2.start();
    }
}
