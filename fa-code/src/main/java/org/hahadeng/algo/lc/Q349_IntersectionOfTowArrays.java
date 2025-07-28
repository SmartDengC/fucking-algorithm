package org.hahadeng.algo.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">...</a>
 *
 * @author 邓聪
 * @since 2025/7/2 20:07
 */
public class Q349_IntersectionOfTowArrays {

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
    public int[] intersectionByStream(int[] nums1, int[] nums2) {
        Set<Integer> st = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(st::remove).toArray();
    }

    /**
     * 纯代码实现
     * 将nums1转化成set
     * 然后在遍历nums，循环每个元素，判断如果在set里面，就添加到列表里面
     * 这里为什么是列表？因为不知道结果有多少个元素。
     * 最后再将lit转化成数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        for(int x: nums1){
            st.add(x);
        }
        List<Integer> lit = new ArrayList<>();
        for(int x: nums2){
            if(st.remove(x)){
                lit.add(x);
            }
        }
        int[] ans = new int[lit.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = lit.get(i);
        }
        return ans;
    }

}
