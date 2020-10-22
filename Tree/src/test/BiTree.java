package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

/**
 * @Author LiYun
 * @Date 2020/9/6 7:23
 * @Version 1.0
 */
public class BiTree {

    public static void main(String[] args) {
        BiNode a = new BiNode();
        createBiTree(a);

    }

    public static BiNode createBiTree(BiNode binode){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == -1){
            return null;
        }else{
            binode.data = num;
            binode.lchild = createBiTree(new BiNode());
            binode.rchild = createBiTree(new BiNode());
            return binode;
        }
    }
}
class BiNode{
    int data;
    BiNode lchild;
    BiNode rchild;
}