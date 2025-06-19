package org.hahadeng.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 邓聪
 * @since 2025/4/2 16:56
 */
public class Q2873 {
    public long maximumTripletValue(int[] nums) {

        long mx = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) (nums[i] - nums[j]) * nums[k];
                    mx = Math.max(mx, sum);
                }
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1000000, 1, 1000000};
//        Q2873 q2873 = new Q2873();
//        System.out.println(q2873.maximumTripletValue(nums));
        Set<Integer> set = new HashSet<>();
        boolean add = set.add(1);
        boolean add1 = set.add(1);
        System.out.println(add);
        System.out.println(add1);

    }
}
