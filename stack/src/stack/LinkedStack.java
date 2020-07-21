package stack;

/**
 * @Author LiYun
 * @Date 2020/7/21 8:51
 * 链栈的实现，相当于只能在头部插入和删除的单链表
 */
public class LinkedStack {
    private int size ;
    private StackNode top ;


    public void push(Object obj){
        top = new StackNode(obj,top);
        size++;
    }

    public void pop(){
        StackNode oldnode = top;
        top = top.next;
        oldnode.next = null;
        size--;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for(StackNode t = top;t != null;t = t.next){
            sb.append(t.value +",");
        }
        sb.setCharAt(sb.length()-1,'}');

        return sb.toString();

    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("aaa");
        stack.push("ok");

        System.out.println(stack);

    }

}

class StackNode{
    public Object value;
    public StackNode next;

    public StackNode(Object value, StackNode next) {
        this.value = value;
        this.next = next;
    }


}
