package org.hahadeng.algo.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">...</a>
 *
 * @author 邓聪
 * @since 2025/7/2 20:07
 */
public class Q349_IntersectionOfTwoArrays {

    /**
     * 求两个数组的交集，转化成两个Set，然后通过遍历循环判断是否是交集元素
     */
    public int[] intersectionBySet(int[] nums1, int[] nums2) {
        // 求数组的交集
        Set<Integer> n1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> ans = n1.stream().filter(n2::contains).collect(Collectors.toList());
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    /**
     * 将nums1转化成set，通过stream将st中的元素删除
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(st::remove).toArray();
    }

    public static void main(String[] args) {
        Map<String, Integer> cnt = new HashMap<>();
        String key = "Joe";

        cnt.computeIfAbsent(key, k -> 0);
        cnt.put(key, cnt.get(key) + 1);
    }

}
