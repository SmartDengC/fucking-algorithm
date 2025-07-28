package org.hahadeng.algo.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/
 *
 * @author HaHaDeng
 * @since 2025/7/2 23:05
 */

public class Q350_IntersectionOfTowArraysII {
    /**
     * 开始没有看懂题目
     * 题目的意思，就是求两个数组元素的交集
     * 只不过当两个数组，相同元素出现的次数不同的时候，以出现次数少的为答案
     * 比如：nums1[1,2,2], nums2[2], 结果为[2]， 因为nums2中只出现了一次2，只能抵扣nums1中2一次
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int x: nums1){
            cnt.merge(x, 1, Integer::sum);
        }

        List<Integer> lit = new ArrayList<>();
        for(int x: nums2){
            Integer xcnt = cnt.getOrDefault(x, 0);
            if(xcnt>0){
                lit.add(x);
                cnt.put(x, cnt.get(x) - 1);
            }
        }
        int[] ans = new int[lit.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = lit.get(i);
        }
        // 优化输出
        // lit.stream().mapToInt(i -> i).toArray();
        return ans;
    }

}
