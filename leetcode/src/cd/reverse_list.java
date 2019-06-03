package cd;

/**
 * @ClassName reverse_list
 * @Description TODO
 * @Author lenovo
 * @Date 2019/6/3 20:35
 */
public class reverse_list {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public int[] twoSum(int[] nums, int target) {
        /**
         * Given nums = [2, 7, 11, 15], target = 9,
         *
         * Because nums[0] + nums[1] = 2 + 7 = 9,
         * return [0, 1].
         */
        int[] res = null;
        for (int i=0;i<nums.length;i++){
            for (int j = 1;j<nums.length;j++){
                if (target == j+i){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

     public ListNode reverseBetween(ListNode head, int m, int n) {
         // 1:找到 开始逆序的开始的地方
         int change_len = n-m+1;
         ListNode pre_head = null; // 表示逆序前的节点
         ListNode result = head; // 表示最终需要返回的节点
         // if m = 2,
         while(head!=null && m-->0){
             pre_head = head; // pre_head 指向 head
             head.next = head; // 向下移动一个
         }
         ListNode modify_list_tail = head; // 表示最后 change 的节点
         // 2: 实现 中间链表的反转
         ListNode new_head = null;
         while(head!=null && change_len>0){
             ListNode next = head.next;
             head.next = new_head;
             new_head = head;
             head = next;
             change_len--;
         }
         // 3：链接 链表
         modify_list_tail.next = head;
         if (pre_head != null){// 表示 的是m 是 0
             pre_head.next = new_head;
         }
         else {//表示m 0
             result = new_head;
         }
         return result;

     }
    public int reverse(int x) {
        /**
         * Example 1:
         *
         * Input: 123
         * Output: 321
         * Example 2:
         *
         * Input: -123
         * Output: -321
         * Example 3:
         *
         * Input: 120
         * Output: 21
         */
        int i=0,j=0,k=0;
        int result = 0;
        if (x>0){
            i = x/100;
            j = x%100/10;
            k = x%10;
            result = k*100+j*10+i;
        }else if (x == 0){
            result = 0;
        }else {
            x = -x;
            i = x/100;
            j = x%100/10;
            k = x%10;
            result = k*100+j*10+i;

        }

        return result;
    }


}
