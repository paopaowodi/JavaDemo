package cn.ly.collecion;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的使用
 * @Author LiYun
 * @Date 2020/7/14 14:57
 */
public class TestMap {
    public static void main(String[] args) {

        Map<Integer,String> m1 = new HashMap<>();

        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");

        System.out.println(m1.get(1));

        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("four"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(4,"四");
        m2.put(5,"五");
        m1.putAll(m2);
        System.out.println(m1);


    }
}
