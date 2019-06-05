package Q151_Q200.L160;

/**
 * @ClassName Leetcode_160
 * @Author lenovo
 * @Date 2019/6/4 17:45
 * @Description TODO
 */
public class Leetcode_160 {
    /**
     * 3步：
     * 1：计算两个链表的长度，
     * 2：将两个链表对齐
     * 3：遍历连个链表，判断是否相交
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    /**
     * 测试：链表添加节点
     * @param head link head
     * @param x node val
     */
     public void addNode(ListNode head,int x){
         if (head==null) {
             return;
         }
         ListNode node = new ListNode(x);
         ListNode nextNode = head ;
         while(nextNode.next!=null){
             nextNode = nextNode.next;
         }
         nextNode.next = node;
     }

    /**
     * init head
     * @param x node val
     * @return ListNode
     */
     public ListNode generatNode(int x) {
         return new ListNode(x);
     }
    /**
     * 计算链表长度
     * @param head ListNode head
     * @return ListNode len
     */
    public int get_link_len(ListNode head){
        int len = 0;
        while (head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    /**
     * 移动较长链表的头指针
     * @param long_len longer ListNode len
     * @param short_len  shorter ListNode len
     * @param head longer ListNode head
     * @return changed head
     */
    public ListNode move_link(int long_len, int short_len, ListNode head){
        int move_len = long_len - short_len;
        while(head!=null && move_len>0){
            head = head.next;
            move_len--;
        }
        return head;
    }
    /**
     * Find intersection node
     * @param headA headA
     * @param headB headB
     * @return Intersection node
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_a = get_link_len(headA);
        int len_b = get_link_len(headB);
        int change_len = 0;
        if (len_a>len_b){
            headA = move_link(len_a, len_b, headA);
        }else{
            headB = move_link(len_b, len_a, headB);
        }
        while (headA!=null && headB!=null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


}
