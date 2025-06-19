package org.hahadeng.algo.slidewindow.nofixlength;

import java.util.Arrays;

/**
 * @author 邓聪
 */
public class Q2024 {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        char[] s = answerKey.toCharArray();
        int ans = 0;
        int left = 0;
        // 统计T和F的个数
        int[] cnt = new int[2];
        for (int right = 0; right < s.length; right++) {
            // 存入到cnt里面
            cnt[s[right] >> 1 & 1]++;
            // 如果T的个数或者F的个数大于k，这里就是重要的判断
            while (cnt[0] > k && cnt[1] > k) {
                // 就把left位置所在的符号的次数减一
                cnt[s[left++] >> 1 & 1]--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(Q2024.maxConsecutiveAnswers(answerKey, k));
        int[] cnt = new int[]{1, 2, 3};
        System.out.println(Arrays.stream(cnt).sum());
    }
}
