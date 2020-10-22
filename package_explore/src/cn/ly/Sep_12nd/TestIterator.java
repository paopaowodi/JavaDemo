package cn.ly.Sep_12nd;

import java.util.*;
import java.util.HashMap;

/**
 * @Author LiYun
 * @Date 2020/9/12 19:59
 * 测试迭代器遍历 List、Set、Map
 */
public class TestIterator {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        //使用迭代器遍历list
        for(Iterator<String> iter = list.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }

    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        //使用迭代器遍历set
        for(Iterator<String> iter = set.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }

    }

    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(100,"aa");
        map.put(200,"bb");
        map.put(300,"cc");

        //第一种遍历Map的方式
        Set<Map.Entry<Integer, String>> ss = map.entrySet();
        //使用迭代器遍历map
        for(Iterator<Map.Entry<Integer,String>> iter = ss.iterator();iter.hasNext();){
            Map.Entry<Integer, String> temp = iter.next();

            System.out.println(temp.getKey()+"---"+temp.getValue());
        }

        //第二种遍历Map的方式
        Set<Integer> keySet = map.keySet();
        for(Iterator<Integer> iter = keySet.iterator();iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key + "---" + map.get(key));
        }
    }


}
