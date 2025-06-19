package org.hahadeng.algo.juejin;

/**
 * @author 邓聪
 */
public class Q90 {
    public static String solution(int v, int w) {
        // Edit your code here
        // dp[i] 表示是否可以用给定的货币面值组合出价格i
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        for (int power = 0; ; power++) {
            // v = 10, w =9

            int value = (int) Math.pow(v, power);

            if (value > w) {
                break;
            }
            // 状态转移
            for (int i = w; i >= value; i--) {
                //
                // value 小于w
                int tmp = w - value;
                
                if (dp[i - value]) {
                    dp[i] = true;
                }
//                int tmp = (int) Math.pow(v, 2);
                if (i >= 2 * value && dp[i - 2 * value]) {
                    dp[i] = true;
                }
            }
        }
        return dp[w] ? "YES" : "NO";
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(10, 9) == "YES");
        System.out.println(solution(200, 40199) == "YES");
        System.out.println(solution(108, 50) == "NO");

    }
}
