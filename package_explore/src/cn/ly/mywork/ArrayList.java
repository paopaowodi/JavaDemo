package cn.ly.mywork;

/**
 * @Author LiYun
 * @Date 2020/7/15 8:47
 * @Version 1.0
 */
public class ArrayList {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public ArrayList(int CAPACITY){
        elementData = new Object[CAPACITY];
    }

    public void add(Object element){

        if(size == elementData.length){
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }

        elementData[size++] = element;
    }

    public Object get (int index){
        return elementData[index];
    }

    public void remove (int index){
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[size--] = null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size; i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList s1 = new ArrayList();
        for(int i = 0; i < 40; i++){
            s1.add(i);
        }
        System.out.println(s1);
    }


}
