package cn.ly.mywork;

import java.util.Arrays;

/**
 * @Author LiYun
 * @Date 2020/7/15 9:40
 * @Version 1.0
 */
public class HashMap {

    Node[] table;
    int size;

    public HashMap(){
        table = new Node[16];
    }

    public void put(Object key, Object value){
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        boolean keyRepeat = false;

        Node temp = table[newNode.hash];

        Node iterLast = null;



        if(temp == null){
            table[newNode.hash] = newNode;
            size++;
        }else{
            if(temp.key.equals(newNode.key)){
                keyRepeat = true;
                temp.value = newNode.value;
            }else{
                iterLast = temp;
                temp = temp.next;
            }
            if(!keyRepeat){
                temp.next = newNode;
                size++;
            }



        }


    }

    public int myHash(int v,int length){
        return v&(length-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for(int i = 0; i < table.length; i++){
            Node t = table[i];
            while(t != null){
                sb.append("key:"+t.key+" value:"+t.value+",");
                t = t.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public Object get (Object key){
        int hash = myHash(key.hashCode(),table.length);
        Object value = null;

        if(table[hash] != null){
            Node t = table[hash];
            while(t != null){
                if(t.key.equals(key)){
                    value = t.value;
                    break;
                }else{
                    t =t.next;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        HashMap m1 = new HashMap();
        m1.put(10,"kkk");
        m1.put(20,"wow");
        m1.put(30,"good");

        System.out.println(m1);
        System.out.println(m1.get(10));
    }

}

class Node{
    int hash;
    Object key;
    Object value;
    Node next;

}