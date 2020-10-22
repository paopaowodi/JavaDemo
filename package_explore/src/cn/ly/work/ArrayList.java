package cn.ly.work;

import java.util.Arrays;

/**
 * @Author LiYun
 * @Date 2020/7/22 14:34
 * ArrayList功能: add get remove set
 */
public class ArrayList <E>{
    private Object[] elementData;
    private int size;
    private final static int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public ArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e){
        if(size == elementData.length){
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = e;
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void checkRange(int index){
        if(index < 0 || index > elementData.length-1){
            throw new RuntimeException("索引不合法"+index);
        }
    }

    public void set(int index,E e){
        checkRange(index);
        elementData[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for(int i = 0; i < size; i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("abc");
        a.add("bcd");

        System.out.println(a);
    }
}
