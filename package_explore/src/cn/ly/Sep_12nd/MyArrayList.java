package cn.ly.Sep_12nd;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Arrays;

/**
 * @Author LiYun
 * @Date 2020/9/12 15:03
 * 自定义实现ArrayList
 * 功能:
 * 1.构造器
 * 2.add
 * 3.
 */
public class MyArrayList{
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity){
        elementData = new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++] = obj;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append('[');
       for(int i =0; i<size;i++){
           sb.append(elementData[i]+",");
       }
       sb.setCharAt(sb.length()-1,']');
       return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList s1 = new MyArrayList();
        s1.add("a");
        s1.add("b");
        System.out.println(s1);
    }

}
