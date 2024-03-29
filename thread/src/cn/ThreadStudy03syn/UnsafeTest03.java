package cn.ThreadStudy03syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiYun
 * @Date 2020/9/8 23:11
 * 线程不安全 ： 操作容器
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
