package org.hahadeng.algo.bitwiseoper;

import org.junit.Test;

/**
 * @author 邓聪
 * @since 2025/4/28 18:01
 */
public class Q461 {
    public int hammingDistance(int x, int y) {
        // 求 x 异或 y之后1的个数，
        int s = x ^ y;
        int cnt = Integer.bitCount(s); // 表示二进制的位数
        int ans = 0;
        for (int i = 0; i < cnt; i++) {
            if (((s >> i) & 1) == 1) {
                ans++;
            }
        }
        return ans;

    }

    @Test
    public void test() {
        int i = hammingDistance(3, 1);
        System.out.println(i);
    }

    @Test
    public void test2() {
        // 10 前面有30个0
        System.out.println(Integer.numberOfLeadingZeros(2));
        // c
        System.out.println(Integer.numberOfTrailingZeros(4));
    }
}
