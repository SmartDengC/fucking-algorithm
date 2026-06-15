package cn;// 给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,1,1,1], target = 3
// 输出：5
// 解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1], target = 1
// 输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2307 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {

        return 0;
    }

    public int package01() {
        int[] w = {2, 1, 3};
        int[] v = {4, 2, 3};
        int capacity = 4;
        int n = w.length;

        int[][] memo = new int[n][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(n - 1, capacity, memo, w, v);
    }

    public int dfs(int i, int c, int[][] memo, int[] w, int[] v) {
        // 题目从前 i 个物品中获取的最大价值和
        // dfs(i, c) = max(dfs(i-1, c-w[i]) + v[i], dfs(i-1, c))
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) {
            return memo[i][c];
        }
        if (c < w[i]) {
            memo[i][c] = dfs(i - 1, c, memo, w, v);
            return memo[i][c];
        }

        memo[i][c] = Math.max(dfs(i - 1, c, memo, w, v), dfs(i - 1, c - w[i], memo, w, v) + v[i]);
        return memo[i][c];
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();
        int i = s.package01();
        System.out.println(i);
    }

}
// leetcode submit region end(Prohibit modification and deletion)
