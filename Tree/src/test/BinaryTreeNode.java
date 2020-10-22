package test;

/**
 * @Author LiYun
 * @Date 2020/9/5 22:52
 * @Version 1.0
 */
public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> lchild;
    BinaryTreeNode<T> rchild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    BinaryTreeNode(){
        this.data = null;
        this.lchild = null;
        this.rchild = null;
    }

    BinaryTreeNode(T data){
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> lchild, BinaryTreeNode<T> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public BinaryTreeNode<T> getLchild() {
        return lchild;
    }

    public void setLchild(BinaryTreeNode<T> lchild) {
        this.lchild = lchild;
    }

    public BinaryTreeNode<T> getRchild() {
        return rchild;
    }

    public void setRchild(BinaryTreeNode<T> rchild) {
        this.rchild = rchild;
    }

    public boolean isLeaf(){
        if(this.lchild == null && this.rchild == null){
            return true;
        }
        return false;
    }

}
