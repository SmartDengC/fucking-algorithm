package org.hahadeng.algo.slidewindow.nofixlength;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邓聪
 */
public class Q2958 {
    public static int maxSubarrayLength(int[] nums, int k) {
        // 求子数组某一个元素出现次数小于等于2的最长子数组的长度
        int ans = 0;
        int left = 0;
        int len = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int right=0;right<nums.length;right++){
            cnt.merge(nums[right], 1, Integer::sum);
            while(cnt.get(nums[right]) > k){

                cnt.merge(nums[left], -1, Integer::sum);
                if(cnt.get(nums[left]) == 0){
                    cnt.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        // System.out.println(Q2958.maxSubarrayLength(nums, k));
        String s = "hello";
        System.out.println(s.length());
        System.out.println(s.indexOf(1));
    }
}
