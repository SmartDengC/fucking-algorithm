package structe;

/**
 * 单链表
 *
 * @author 邓聪
 * @since 15.06.26 11:02
 */
public class SingleLinkedList {

    public ListNode createSingleLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);

        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }


    public void showLinedList(ListNode head) {
        if (head == null) {
            return;
        }

        // head.next != null 遍历到最后一个节点就停止了，不会处理最后一个节点，循环结束，head 指向最后一个节点
        // head != null 遍历到最后一个节点之后的 null 节点， 会处理所有节点，包括最后一个节点，循环结束时，head 执行 null
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = s.createSingleLinkedList(arr);
        s.showLinedList(head);
    }

}
