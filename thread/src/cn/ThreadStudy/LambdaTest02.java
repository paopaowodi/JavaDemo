package cn.ThreadStudy;

/**
 * @Author LiYun
 * @Date 2020/9/8 18:13
 * @Version 1.0
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("一边学习lambda")).start();
        new Thread(()-> System.out.println("一边看帅哥")).start();

    }
}
