/**
 * @Author LiYun
 * @Date 2020/10/14 20:37
 * 19.给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class _19_RemoveNthNode {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode end = head;
        head.val = 1;
        for (int i = 2; i <=5 ; i++) {
            ListNode p =new ListNode();
            end.next = p;
            end = p;
            end.val = i;
        }
        end.next = null;

        removeNthFromEnd(head,2);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n+1; i++) {
            first = first.next;
        }
        while(first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}