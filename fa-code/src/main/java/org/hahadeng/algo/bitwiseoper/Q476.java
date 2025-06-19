package org.hahadeng.algo.bitwiseoper;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 邓聪
 * @since 2025/4/28 18:31
 */
public class Q476 {
    public int findComplement(int num) {
        // 遍历？
        // 没有好的办法，只能硬解
        String s = Integer.toBinaryString(num);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    @Test
    public void test() {
        System.out.println(findComplement(5));
    }

    @Test
    public void test2() {
        // 求两两个集合的交集
    }

    public Set<Integer> intersection(Set<Integer> s1, Set<Integer> s2) {
        // 小的集合驱动大的集合
        boolean b = s1.size() > s2.size();
        Set<Integer> cloneSet = new HashSet<Integer>(b ? s2 : s1);
        cloneSet.retainAll(b ? s1 : s2);
        return cloneSet;
    }

    public int convert(String binary) {
        Integer x = 0;
        // 1101 -> 1 * 2 ^ 0 + 0 * 2 ^ 1 + 1 * 2 ^ 2 + 1 * 2 ^ 3
        int len = binary.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int n = binary.charAt(len - i - 1) - '0';
            /// 1 << i 表示 Math.pow(2, i)
            ans += n * (1 << i);
        }
        return ans;
    }

    public static int stringSize(int i) {
        if (i == 0) {
            return 1;
        }
        int cnt = 0;
        // 处理i是负数的情况
        i = i < 0 ? -i : i;
        while (i > 0) {
            // java中除以默认是下取整，当结果等于0.1的时候，转成int等于0
            i /= 10;
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test3() {
        // System.out.println(convert("1101"));
        int x = 12;
        // 用静态方法
        String string1 = Integer.toString(x);
        // String string = Integer.toString(x, 2);
        // System.out.println(stringSize(12));
        // 二进制的位数
        int size = Integer.SIZE - Integer.numberOfLeadingZeros(x);
        // System.out.println(Integer.valueOf("12"));
        // System.out.println(Integer.parseInt("12"));
        System.out.println(Integer.bitCount(12));


    }

}
