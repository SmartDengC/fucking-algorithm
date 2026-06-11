package cn;// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
// 被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
// 输入：[1,2,3,1]
// 输出：4
// 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
// 输入：[2,7,9,3,1]
// 输出：12
// 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 3539 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution198 {
    int[] cache;

    public int rob(int[] nums) {
        // nums[1,2,3,1]
        // 如果遍历到第 i 个房子，就变成了选或者不选，
        // 如果不选，就变成了，前 i-1个房子所得的最大金额和
        // 如果选，就变成了，前 i-2 个房子所得的最大金额和

        // dfs(i) = max(dfs(i-1), dfs(i-2) + nums[i])

        // int n = nums.length;
        // cache = new int[n];
        // Arrays.fill(cache, -1);
        //
        // return dfs(n-1, nums);

        int n = nums.length;
        int[] f = new int[n + 2];

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            f[i + 2] = Math.max(f[i + 1], f[i] + x);
        }
        // 为啥是 n+1？
        // 因为所有的结果都向后移动了 2各单位
        return f[n + 1];
    }

    /**
     * 递归的形式
     *
     * @param i
     * @param nums
     * @return
     */
    public int dfs(int i, int[] nums) {
        if (i < 0) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }
        cache[i] = Math.max(dfs(i - 1, nums), dfs(i - 2, nums) + nums[i]);

        return cache[i];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
