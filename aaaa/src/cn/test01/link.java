package cn.test01;

import java.util.Scanner;

/**
 * @Author LiYun
 * @Date 2020/9/13 19:43
 * 反转链表
 */
public class link {
    public static void main(String[] args) {
        Node n1 = new Node();
        Node hh = n1;
        Scanner scanner = new Scanner(System.in);
        while((n1.value = (scanner.nextInt())) != -1){
            Node temp = new Node();
            n1.next = temp;
            n1 = temp;
        }
        n1.next = null;

        Node h = ReLink(hh);
        while( h !=null){
            System.out.println(h.value);
            h = h.next;
        }
    }

    public static Node ReLink(Node node){
        Node t1 = new Node();
        Node tsrc = node;
        t1.next = null;

        while(tsrc != null){
            Node t2 = new Node();
            t1.value = tsrc.value;
            t2.next = t1;
            t1 = t2;
            tsrc = tsrc.next;
        }
        return t1.next;

    }

}

class Node{
    int value;
    Node next;

}