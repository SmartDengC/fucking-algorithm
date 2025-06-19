package org.hahadeng.structe;

import java.util.LinkedList;

/**
 * 双链表
 *
 * @author 邓聪
 */
public class MyDoubleLinkedList {

    public static class DoublyListNode{
        int val;
        DoublyListNode prev, next;
        public DoublyListNode(int x){
            this.val = x;
        }
    }

    public static DoublyListNode createDoubleLinkedList(int[] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode p = head;
        for(int i=1;i<arr.length;i++){
            DoublyListNode tmp = new DoublyListNode(arr[i]);
            p.next = tmp;
            tmp.prev = p;
            p = p.next;
        }
        return head;
    }
    public void addFirst(DoublyListNode head, int x){
        DoublyListNode tmp = new DoublyListNode(x);
        if(head==null){
            head = tmp;
        }
        DoublyListNode p = head;
        while(p.next!=null){
            p = p.next;
        }
        p.next = tmp;
        tmp.prev = p;
    }


    public static void main(String[] args) {
        DoublyListNode head = MyDoubleLinkedList.createDoubleLinkedList(new int[]{1, 2, 3, 4, 5});
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
        LinkedList<Integer> p = new LinkedList<>();
    }
}
