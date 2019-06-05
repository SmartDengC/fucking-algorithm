package cn.Q201_Q250.L206;

/**
 * @ClassName Leetcode_206
 * @Author lenovo
 * @Date 2019/6/5 16:39
 * @Description TODO
 */
public class Leetcode_206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head){
        ListNode new_head = null;
        while (head != null){    // head!=null,判断当前节点是否为空
            ListNode next = head.next;// 保存head的next
            head.next = new_head;// 将head连接到new_head
            new_head = head;// new_head 移动
            head = next;// head向下移动一个
        }
        return new_head;
    }
}
