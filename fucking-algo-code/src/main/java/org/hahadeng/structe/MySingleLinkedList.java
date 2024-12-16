package org.hahadeng.structe;

/**
 * @author: HaHaDeng
 */

public class MySingleLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }

    public static ListNode createListNode(int[] arr){
        if(arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for(int i=1;i<arr.length;i++){
            ListNode tmp = new ListNode(arr[i]);
            cur.next = tmp;
            cur = cur.next;
        }
        return head;
    }

    public ListNode addFirst(ListNode head, int e){
        ListNode tmp = new ListNode(e);
        tmp.next = head;
        head = tmp;
        return head;
    }
    public ListNode addLast(ListNode head, int e){
        ListNode tmp = new ListNode(e);
        ListNode p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = tmp;
        return head;
    }
    public ListNode add(ListNode head, int e){
        // 略
        return null;
    }
    public ListNode removeLast(ListNode head){
        if(head == null) {
            return head;
        }
        ListNode p = head;
        while(p.next.next != null){
            p = p.next;
        }
        p.next = null;
        return head;
    }
    public ListNode removeFirst(ListNode head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = MySingleLinkedList.createListNode(new int[]{1, 2, 3});
        // 循环 while(head != null)
        // 循环 while(head.next != null) 表示不会执行最后一个节点
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
