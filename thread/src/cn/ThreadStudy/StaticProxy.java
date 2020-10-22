package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 17:34
 * 静态代理
 * 接口：
 * 1.真实角色
 * 2.代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();

        //new Thread(线程对象).start();
    }

}
interface Marry{
    void happyMarry();
}
//真实角色
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("结婚了");
    }
}
//代理角色
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready(){
        System.out.println("布置现场");
    }
    private void after(){
        System.out.println("结束");
    }
}