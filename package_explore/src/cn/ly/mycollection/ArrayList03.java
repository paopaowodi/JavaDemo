package cn.ly.mycollection;
/**
 * ArrayList3.0
 * 增加数组扩容功能
 * */

public class ArrayList03<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList03(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList03(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){

        //什么时候扩容
        if(size == elementData.length){
            //扩容操作
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }

        elementData[size++] = element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size ; i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayList03 s1 = new ArrayList03(20);
        for (int i = 0; i < 40; i++){
            s1.add(i);
        }

        System.out.println(s1);
    }

}
