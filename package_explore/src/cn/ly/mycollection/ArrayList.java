package cn.ly.mycollection;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * @author 李云
 * */
public class ArrayList {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity){
        elementData = new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++] = obj;
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
        ArrayList s1 = new ArrayList(20);
        s1.add("aa");
        s1.add("bb");

        System.out.println(s1);
    }

}
