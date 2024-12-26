package org.hahadeng.algo.slidewindow.fixlength;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1652. 拆炸弹
 * <a href="https://leetcode.cn/problems/defuse-the-bomb/description/">...</a>
 * @author 邓聪
 */
public class Q1652 {
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        // r表示第一个窗口的右边下标
        // 所以构建出来一个长度为k，窗口下标为[r-1, r]的窗口
        int r = k> 0? k+1: n;

        k = Math.abs(k);
        int s = 0;

        for(int i = r-k;i<r;i++){
            // 计算ans[0]
            s += code[i];
        }
        for(int i = 0;i<n;i++){
            ans[i] = s;
            s += code[r % n] - code[(r-k) %n];
            r++;  // 每次i向后移动一位，r也向后移动一位
        }
        return ans;
    }

    @Test
    public void q1(){
        int[] code = new int[]{2,4,9,3};
        int k = -2;
        int[] decrypt = Q1652.decrypt(code, k);
        for(int i = 0; i<decrypt.length;i++){
            System.out.println(i);
        }
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry: integerIntegerHashMap.entrySet()){
            Integer value = entry.getValue();

        }

    }

}
