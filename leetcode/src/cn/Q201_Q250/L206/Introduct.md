题目地址：https://leetcode.com/problems/reverse-linked-list/

# 206. Reverse Linked List

# Solve It
## 大概流程
![](图一.png)
## 具体流程
1：首先 我们有链表的头部，保存head.next，新建一个new_head的头结点
```
ListNode next = head.next;
ListNode new_head = null;
```
2：将head 链接到new_head 后面
```$xslt
head.next = new_head;
```
3：new_head 指针向前移动
```$xslt
new_head = head;
```
4：head 向后推进一个，循环执行，直到全部逆序完成。
```$xslt
head = head.next;
```

