package cn.ly.mycollection;

/**
 * ArrayList 2.0
 * @author 李云
 * */
public class ArrayList02<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList02(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList02(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
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
        ArrayList02 s1 = new ArrayList02(20);
        s1.add("aa");
        s1.add("bb");

        System.out.println(s1);
    }

}
