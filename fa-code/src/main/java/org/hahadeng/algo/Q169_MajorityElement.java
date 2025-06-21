package org.hahadeng.algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/majority-element/description/">...</a>
 *
 * @author 邓聪
 * @description: -
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * @since 2025/6/22 00:02
 */
public class Q169_MajorityElement {
    public void test() {
        List<Integer> lit = new ArrayList<>();
        lit.add(1);
        lit.add(1);
        lit.add(2);

        TreeMap<Integer, List<Integer>> map = lit.stream().collect(Collectors.groupingBy(Integer::intValue, TreeMap::new, Collectors.toList()));
        map.put(0, Arrays.asList(1, 2));
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // 0
            // [1, 2]
            // 1
            // [1, 1]
            // 2
            // [2]
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * 最简单的解题思路
     * 就是统计每个元素出现的次数，返回大于n/2的元素
     */
    public int majorityElementByMap(int[] nums) {
        // 求 大于 一半的数
        // 统计每个数的个数，然后判断
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = -1;
        int target = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > target) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    /**
     * 排序法
     * 排序后，中间的数一定是多数元素
     * 因为题目给出一定存在元素出现次数大于n/2，所以中间的数一定是答案。
     */
    public int majorityElementBySort(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 摩尔投票法
     * <p>
     * 假设第一个数是众数，然后遍历数组，如果当前数和假设的数相同，则计数器加一，否则减一。当计数器为0时，假设下一个数是众数，继续遍历。最后剩下的数就是众数。
     * 候选人(candidate)初始化为 nums[0]，票数 count 初始化为 1。
     * 当遇到与 candidate 相同的数，则票数 count = count + 1，否则票数 count = count - 1。
     * 当票数 count 为 0 时，更换候选人，并将票数 count 重置为 1。
     * 遍历完数组后，candidate 即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则 票数 + 1，遇到不同的则 票数 - 1。
     * 且“多数元素”的个数 > ⌊ n/2 ⌋，其余元素的个数总和 <= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个 “多数元素” 和其他元素 两两相互抵消，抵消到最后肯定还剩余 至少1个 “多数元素”。
     * 无论数组是 1 2 1 2 1，亦或是 1 2 2 1 1，总能得到正确的候选人。
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            int e = nums[i];
            if (candidate == e) {
                ++cnt;
            } else if (--cnt == 0) {
                candidate = e;
                cnt = 1;
            }
        }
        return candidate;
    }
}
