package org.hahadeng.algo.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-unique-subarray-sum-after-deletion/description/?envType=daily-question&envId=2025-07-25">...</a>
 * <p>
 * 给你一个整数数组 nums 。
 * <p>
 * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
 * <p>
 * 子数组中的所有元素 互不相同 。
 * 最大化 子数组的元素和。
 * 返回子数组的 最大元素和 。
 * <p>
 * 子数组 是数组的一个连续、非空 的元素序列。
 *
 * @author 邓聪
 * @since 2025/7/25 17:10
 */
public class Q3487_MaximumUniqueSubArraySumAfterDeletion {

    /**
     * 求删除元素后最大的子数组之后。
     * 如果数组元素全是负数的话， 只能选择一个最大的负数。
     * 否则的话，就选择全是正数的元素，但是每个正数只能选一次，可以用哈希表来判断是否选过
     * <p>
     * 开始的时候没有考虑到全为负数的情况。
     *
     * @param nums 数组
     */
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int s = 0;
        int mx = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < 0) {
                mx = Math.max(mx, x);
            }
            // 如果添加成功，就加到s里面
            else if (set.add(x)) {
                s += x;
            }
        }
        return set.isEmpty() ? mx : s;
    }

    public static void modify(int x) {
        x = 2;
    }

    public static void main(String[] args) {
        int x = 0;
        modify(x);
        System.out.println(x);
    }

}
