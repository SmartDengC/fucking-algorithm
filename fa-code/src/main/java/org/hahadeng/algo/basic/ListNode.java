package org.hahadeng.algo.basic;

/**
 * 单链表节点
 *
 * @author 邓聪
 * @since 2025/8/4 19:25
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
