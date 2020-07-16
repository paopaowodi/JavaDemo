package cn.ly.mycollection;

/**
 * @Author LiYun
 * @Date 2020/7/14 16:09
 * @Version 3.0
 * 实现 get 方法， 根据键对象获得对应的值对象
 */
public class HashMap03 {
    Node2[] table;  //bucket array
    int size;       //键值对的个数

    public HashMap03(){
        table = new Node2[16]; //长度2的整数次幂
    }

    public Object get (Object key){
        int hash = myHash(key.hashCode(),table.length);
        Object value = null;

        if(table[hash] != null){
            Node2 temp = table[hash];

            while(temp != null){
                if(temp.key.equals(key)){
                    value = temp.value;
                    break;
                }else{
                    temp = temp.next;
                }
            }

        }
        return value;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        //遍历bucket array
        for(int i = 0; i < table.length; i++){
            Node2 temp = table[i];
            //遍历链表
            while(temp != null){
                sb.append(temp.key+":"+temp.value+",");
                temp = temp.next;
            }

        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    public int myHash(int v, int length){

        return v&(length-1);
    }



    public static void main(String[] args) {
        HashMap03 m = new HashMap03();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(26,"dd");

        System.out.println(m.get(10));
        System.out.println(m.get(26));

        System.out.println(m);
    }

}
