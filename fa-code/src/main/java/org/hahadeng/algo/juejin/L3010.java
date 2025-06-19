package org.hahadeng.algo.juejin;

import java.util.Arrays;

/**
 * @author 邓聪
 * @since 2025/3/4 17:59
 */
public class L3010 {
    public static int minimumCost(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0];
        int last = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt >= 3) {
                break;
            }
            if (nums[i] != last) {
                ans += nums[i];
                last = nums[i];
                cnt++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 1, 1};
        int i = L3010.minimumCost(nums);
    }
}
