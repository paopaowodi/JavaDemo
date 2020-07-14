package cn.ly.mycollection;
/**
 * ArrayList4.0
 * 增加set和get方法
 * 增加数组边界的检查
 * */

public class ArrayList04<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList04(){

        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList04(int capacity){

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

    public E get(int index){
       checkRange(index);
        return  (E)elementData[index];
    }

    public void set(E element, int index){
        //索引合法判断[0,size)
        checkRange(index);
        elementData[index] = element;
    }
    public void checkRange(int index){
        if(index < 0 || index > size -1){
            throw new RuntimeException("索引不合法:"+index);
        }
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
        ArrayList04 s1 = new ArrayList04(20);
        for (int i = 0; i < 40; i++){
            s1.add(i);
        }
        s1.set("ddd",10);

        System.out.println(s1);
        System.out.println(s1.get(39));
    }

}
