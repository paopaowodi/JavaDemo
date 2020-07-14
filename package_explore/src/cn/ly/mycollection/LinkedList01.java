package cn.ly.mycollection;
/**
 * 自定义一个链表
 * @author 李云
 * */
public class LinkedList01 {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj){
        Node node = new Node(obj);

        if(first == null){

            first = node;
            last = node;
        }else{
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
    }
}
