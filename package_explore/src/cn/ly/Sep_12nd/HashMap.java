package cn.ly.Sep_12nd;

import java.util.Arrays;

/**
 * @Author LiYun
 * @Date 2020/9/12 16:43
 * 自定义 HashMap
 */
public class HashMap {

    Node[] table;  //位桶数组
    int size;  //存放多少键值对
    int number;
    private static final double LOAD_FACTOR = 0.75;

    public HashMap(){
        table = new Node[16];  //长度一定是2的整数次幂
    }

    public void put(Object key, Object value){

        //扩容操作
        if(number > table.length * LOAD_FACTOR){
            //如何扩容
            Node[] newTable = new Node[table.length << 1];
            //循环位桶数组
            for (int i = 0; i < table.length; i++) {

                Node t1 = table[i];
                //遍历链表
                while(t1 != null){

                    Node t2 = newTable[MyHash(t1.key.hashCode(),newTable.length)];

                    if(t2 == null){
                        newTable[MyHash(t1.key.hashCode(),newTable.length)] = t1;
                    }else{
                        while(t2.next != null){
                                //把node加到最后
                                t2 = t2.next;
                            }
                        t2.next = t1;
                        }
                    t1 = t1.next;
                }

                }
            table = newTable;
            }
        //定义了新的节点对象
        Node node = new Node();
        node.hash = MyHash(key.hashCode(),table.length);
        node.key = key;
        node.value = value;
        node.next = null;

        Node temp = table[node.hash];

        if(temp == null){
            table[node.hash] = node;
            number++;
        }else{
            while(temp.next != null){
                //判断Key是否重复，覆盖
                if(temp.key.equals(key)){
                    temp.value = node.value;
                    break;
                }else{
                //若不重复，则把node加到最后
                    temp = temp.next;
                }
            }
            if(temp.key.equals(key)){
                temp.value = node.value;
            }else{
                temp.next = node;
                number++;
            }

        }

    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append('[');
       //循环数组
        for (int i = 0; i < table.length; i++) {
            //遍历链表
            Node temp = table[i];

            while(temp != null){
                sb.append(temp.key + ":"+ temp.value+",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();


    }

    public Object get(Object key){
        int hash = MyHash(key.hashCode(),table.length);
        Node temp = table[hash];
        if(temp == null){
            return null;
        }else{
            while(temp != null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return  null;
    }

    public int MyHash(int hashcode, int length){
        return hashcode&(length-1);
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i < 18; i++) {
            map.put(i*3,"value"+i);
        }

        System.out.println(map);
    }

}

class Node{
    int hash;
    Object key;
    Object value;
    Node next;
}
