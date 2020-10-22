package test;

/**
 * @Author LiYun
 * @Date 2020/9/5 14:41
 * 左右根
 */
public class LRD {
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
    }

    public static void postOrder(TreeNode biTree){
        if(biTree == null){
            return;
        }else{
            postOrder(biTree.lchild);
            postOrder(biTree.rchild);
            System.out.println(biTree.value);
        }
    }
}
