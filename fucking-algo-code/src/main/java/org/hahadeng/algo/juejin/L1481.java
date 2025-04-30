package org.hahadeng.algo.juejin;

import java.util.*;

/**
 * @author 邓聪
 * @since 2025/3/4 17:20
 * <a href="https://leetcode.cn/problems/least-number-of-unique-integers-after-k-removals/description/">...</a>
 */
public class L1481 {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.merge(num, 1, Integer::sum);
        }

        List<int[]> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            // 创建数组的方式 int[] keys = {1,2,3,4}
            int[] keyValue = {entry.getKey(), entry.getValue()};
            freq.add(keyValue);
        }

        freq.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] k1, int[] k2) {
                return k1[1] - k2[1];
            }
        });

        int ans = freq.size();
        for (int i = 0; i < freq.size(); i++) {
            int occ = freq.get(i)[1];
            if (k >= occ) {
                ans -= 1;
                k -= occ;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3};
        int[] arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        L1481.findLeastNumOfUniqueInts(arr, k);
    }
}
