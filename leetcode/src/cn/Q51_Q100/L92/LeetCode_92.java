package cn.Q51_Q100.L92;

/**
 * @ClassName LeetCode_92
 * @Author lenovo
 * @Date 2019/6/3 21:30
 * @Description
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class LeetCode_92 {
    // TO Define the Class of ListNode
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     *
     * @param head 表示是链表的头指针
     * @param m 表示 开始逆置的位置
     * @param n 表示 结束逆置的位置
     * @return 逆置后的头指针
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 一:找到 开始逆序的开始的地方
        int change_len = n-m+1;  // 表示逆置 的长度
        ListNode pre_head = null; // 表示逆置前一个的节点
        ListNode result = head; // 表示最终需要返回的节点
        while(head!=null && m-->0){  // head 移动
            pre_head = head; // pre_head 指向 head
            head = head.next; // 向下移动一个
        }
        ListNode modify_list_tail = head; // 表示最后 change 之后的最后一个节点
        // 2: 实现 中间链表的反转
        ListNode new_head = null;
        while(head!=null && change_len>0){
            ListNode next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
            change_len--;
        }
        // 3：链接 链表
        modify_list_tail.next = head;
        if (pre_head != null){// 表示 的是m 是 0
            pre_head.next = new_head;
        }
        else {//表示m 0
            result = new_head;
        }
        return result;
    }
}
