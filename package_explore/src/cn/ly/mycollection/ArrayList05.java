package cn.ly.mycollection;
/**
 * ArrayList4.0
 * 增加remove
 * */

public class ArrayList05<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList05(){

        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList05(int capacity){

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
    public void remove(E element){
        //element 和元素比较 得到第一个比较为true的返回
        for(int i = 0; i < size; i++){
            if(element.equals(get(i))){
                //移除操作
                remove(i);
            }
        }
    }

    public void remove(int index){
        //a,b,c,d,e,f,g
        //a,b,c,e,f,g
        int numMoved = size-index-1;
        if(numMoved >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
         elementData[size--] = null;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0?true:false;
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
        ArrayList05 s1 = new ArrayList05(20);
        for (int i = 0; i < 40; i++){
            s1.add(i);
        }
        s1.set("ddd",10);
        s1.remove(3);
        System.out.println(s1);
        System.out.println(s1.size);
        System.out.println(s1.isEmpty());
    }

}
