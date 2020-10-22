/**
 * @Author LiYun
 * @Date 2020/10/19 15:14
 *
 * 101.
 * 给定一个二叉树，检查它是否是镜像对称的。
 **/

public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return dfsSymmetric(root.left,root.right);
    }
    public boolean dfsSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left != null && right == null){
            return false;
        }
        if(left == null || right != null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return dfsSymmetric(left.left,right.right) && dfsSymmetric(left.right,right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}