package test;

/**
 * @Author LiYun
 * @Date 2020/9/5 13:55
 * 先根遍历  中 左 右
 */
public class VLR {
    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if(i*2 + 1< 10){
                node[i].lchild = node[i*2+1];
            }
            if(i*2 + 2 < 10){
                node[i].rchild = node[i*2+2];
            }

        }
        preOrder(node[0]);
    }
    public static void preOrder(TreeNode biTree){
        System.out.println(biTree.value);
        TreeNode leftTree = biTree.lchild;
        if(leftTree != null){
            preOrder(leftTree);
        }
        TreeNode rightTree = biTree.rchild;
        if(rightTree != null){
            preOrder(rightTree);
        }
    }

}

class TreeNode{
    int value;
    TreeNode lchild;
    TreeNode rchild;

    TreeNode(int value){
        this.value = value;
    }
}