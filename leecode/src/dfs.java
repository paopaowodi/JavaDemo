import java.util.Stack;

/**
 * @Author LiYun
 * @Date 2020/10/19 14:07
 * @Version 1.0
 */
public class dfs {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void dfsWithStack(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        //先把根结点压栈
        stack.push(root);
        while(!stack.isEmpty()){
            Node treeNode = stack.pop();
            //遍历节点
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }

    public static void dfs(Node treeNode){
        if(treeNode == null){
            return;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);
    }

}
