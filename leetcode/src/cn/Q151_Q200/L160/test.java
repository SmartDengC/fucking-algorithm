package cn.Q151_Q200.L160;
import cn.Q151_Q200.L160.Leetcode_160;
import cn.Q151_Q200.L160.Leetcode_160.*;

/**
 * @ClassName test
 * @Author lenovo
 * @Date 2019/6/5 14:51
 * @Description TODO
 */
public class test {

    public static void main(String[] args)
    {

        Leetcode_160 leetcode_160 = new Leetcode_160();
        ListNode headA = leetcode_160.generatNode(4);
        leetcode_160.addNode(headA, 1);
        ListNode headB = leetcode_160.generatNode(5);
        leetcode_160.addNode(headB,0);
        leetcode_160.addNode(headB,1);
        ListNode headC=  leetcode_160.generatNode(8);
        leetcode_160.addNode(headC, 4);
        leetcode_160.addNode(headC, 5);

        ListNode nextNodeA = headA;
        ListNode nextNodeB = headB;

        while(nextNodeA.next!=null){
            nextNodeA = nextNodeA.next;
        }
        nextNodeA.next = headC;
        while (nextNodeB.next!=null){
            nextNodeB = nextNodeB.next;
        }
        nextNodeB.next = headC;

        ListNode head = leetcode_160.getIntersectionNode(headA, headB);
        System.out.println(head.val);






    }

}
