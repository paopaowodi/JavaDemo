package cn.ly.mycollection;

/**
 * @Author LiYun
 * @Date 2020/7/14 16:09
 * @Version 1.0
 * 自定义一个HashMap
 */
public class HashMap01 {
    Node2[] table;  //bucket array
    int size;       //键值对的个数

    public HashMap01(){
        table = new Node2[16]; //长度2的整数次幂
    }
    public void put(Object key, Object value){
       //定义新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        boolean keyRepeat = false;

        Node2 temp = table[newNode.hash];

        Node2 iterLast = null; //正在遍历的最后一个元素

        if(temp == null){
            table[newNode.hash] = newNode;
        }else{
            //遍历对应链表
            while(temp != null){
                //判断key如果重复则覆盖
                if(temp.key.equals(key)){
                    keyRepeat = true;
                    temp.value = value;
                    break;
                }else{
                //key不重复,遍历下一个
                    iterLast = temp;
                    temp = temp.next;

                }
            }
            if(!keyRepeat){
            iterLast.next = newNode;
            }
        }

    }
    public int myHash(int v,int length){
        System.out.println("hash in myHash:"+(v&(length-1)));
        return v&(length-1);
    }

    public static void main(String[] args) {
        HashMap01 m = new HashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(26,"dd");

        System.out.println(m);
    }

}
