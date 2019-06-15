题目链接：https://leetcode.com/problems/intersection-of-two-linked-lists/
# Intersection of Two Linked Lists
![avatar](图一.png)

# Solve It

> 这里分三步  
> 1：计算 两个链表的长度  
```
while(head!=null){
    len++;
    head = head.next;
    }
```
> 2：移动长的链表，使得两个链表相互对齐  
```
// move_len 表示 两个链表相差的长度

while(head!=null && move_len>0){
    head = head.next;
    move_len--;
}
```
![](图二.png)  
> 3：就是判断 两个链表相交的地方
```$xslt
while(headA!=null && headB != headB){
    if(headA == headB){
        return headA;
    }
    headA = headA.next;
    headB = headB.next;
}
```