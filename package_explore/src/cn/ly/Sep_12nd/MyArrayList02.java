package cn.ly.Sep_12nd;

/**
 * @Author LiYun
 * @Date 2020/9/12 15:03
 * 自定义实现ArrayList  增加泛型
 * 功能:
 * 1.构造器
 * 2.add
 * 3.泛型
 * 4.扩容
 * 5.set
 * 6.get
 * 7.边界检查
 * 8.remove
 */
public class MyArrayList02<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList02(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList02(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E e){
        Object[] newArray = null;
        //什么时候扩容
        if(size == elementData.length){
            //如何扩容
            //如果数组长度为1
            if(size ==1){
                newArray = new Object[2];
                System.arraycopy(elementData,0,newArray,0,size);
            }else {
                newArray = new Object[elementData.length+(elementData.length>>1)];
                System.arraycopy(elementData,0,newArray,0,size);
            }

            elementData = newArray; //老数组会被垃圾回收掉
        }

        elementData[size++] = e;
    }
    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }
    public void set(E e,int index){
        checkRange(index);
        elementData[index] = e;
    }

    public void remove(E e){
        for (int i = 0; i < size; i++) {
            if(e.equals(elementData[i])){   //容器中所有的比较操作都是equals
                //移除
                remove(i);
            }
        }
    }

    public void remove(int index){
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[size-1] = null;
        size--;
    }
    public void checkRange(int index){
        //索引合法判断[0,size)
        if(index <0 || index >= size){
            throw new RuntimeException("索引不合法");
        }
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
        MyArrayList02 s1 = new MyArrayList02();
        s1.add("a");
        s1.add("b");
        System.out.println(s1);
    }

}
