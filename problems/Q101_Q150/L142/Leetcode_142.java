package Q101_Q150.L142;

/**
 * @ClassName Leetcode_142
 * @Author lenovo
 * @Date 2019/6/15 14:06
 * @Description TODO
 */
public class Leetcode_142 {
    // Node to search circle

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

   public ListNode detectCycle(ListNode head) {
           ListNode slow = head;
           ListNode fast = head;
           ListNode meet = null;
           while (fast != null){
               slow = slow.next;
               fast = fast.next;
               /**
                while 循环有两个出口，
                一个就是链表没有环，而是链表又环，需要找到环节点
                */
               // 没有环
               if (fast == null){
                   return null;
               }
               fast = fast.next;
               // 又环
               if (fast == slow){
                   meet = fast;
                   break;
               }
           }
           // 没有环
           if (meet == null){
               return null;
           }
           // 有环的结果
           while (head != null && meet != null){
               if (meet == head){
                   return head;
               }
               head = head.next;
               meet = meet.next;
           }
           return null;
   }
}
