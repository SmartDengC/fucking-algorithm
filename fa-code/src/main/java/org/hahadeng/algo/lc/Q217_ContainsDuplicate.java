package org.hahadeng.algo.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate/description/
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * @author HaHaDeng
 * @since 2025/6/30 22:35
 */

public class Q217_ContainsDuplicate {

    /**
     * 最简单的方法就是统计每个数字出现的次数，然后判断是否有大于等于2的
     */
    public boolean containsDuplicateByMap(int[] nums) {
        // 统计每个数字的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int x: nums){
            cnt.merge(x, 1, Integer::sum);
        }
        boolean flag = false;
        for(Map.Entry<Integer, Integer> entry: cnt.entrySet()){
            if (entry.getValue() >= 2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 还有一种方式，就是通过集合去重之后判断集合大小和原来数组的大小
     * 如果小于数组的大小，那么就表示存在重复的元素
     */
    public boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        return set.size() < nums.length;
    }

    /**
     * 还有一种方式，就是在添加的时候，判断是否存在，如果存在直接返回。
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for(int x: nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
