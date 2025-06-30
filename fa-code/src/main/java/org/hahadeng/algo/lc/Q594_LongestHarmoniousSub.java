package org.hahadeng.algo.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-harmonious-subsequence/description/?envType=daily-question&envId=2025-06-30
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 * @author HaHaDeng
 * @since 2025/6/30 22:56
 */
public class Q594_LongestHarmoniousSub {
    /**
     * 因为最小值和最大值差值正好差1，就表示只存在x和x+1的个数
     * 统计每个元素的次数
     * 处理x的时候，判断x+1是否存在，存在的话，更新最后的返回值。
     *
     * 这里需要注意，基础类型只有包装类型才能使用 x != null 判断
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int x = entry.getKey();
            Integer value = cnt.get(x + 1);
            if (value != null) {
                ans = Math.max(entry.getValue() + value, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q594_LongestHarmoniousSub q = new Q594_LongestHarmoniousSub();
        int[] nums = {1,3,2,2,5,2,3,7};
        int lhs = q.findLHS(nums);
        System.out.println(lhs);
    }
}
