package Q51_Q100.L86;

/**
 * @ClassName Leetcode_86
 * @Author lenovo
 * @Date 2019/6/15 14:52
 * @Description TODO
 */
public class Leetcode_86 {
    // 均分连表
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less_head = new ListNode(0);    // 创建一个less_head 节点
        ListNode more_head = new ListNode(0);    // 创建一个more_head 节点
        ListNode less_ptr = less_head;    // less_ptr 节点指向 less_head
        ListNode more_ptr = more_head;    // 同理
        while (head != null){// 遍历原链表
            if (head.val < x){ // 判断 原链表的值与x值得大小
                less_ptr.next = head;//将 节点链接在less_ptr 后面
                less_ptr = head;// less_ptr指向链接后的节点
            }
            else {
                more_ptr.next = head;
                more_ptr = head;
            }
            head = head.next; // head向后移动
        }
        // 将 分段后的连表串联起来
        less_ptr.next = more_head.next;
        more_ptr.next = null; // 最后一个节点的next至为空
        return less_head.next;
    }
}
