package cn;
// 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 5
// 输出：true
// 解释：5 的二进制表示是：101
// 
//
// 示例 2： 
//
// 
// 输入：n = 7
// 输出：false
// 解释：7 的二进制表示是：111.
//
// 示例 3： 
//
// 
// 输入：n = 11
// 输出：false
// 解释：11 的二进制表示是：1011.
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 258 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution693 {
    public boolean hasAlternatingBits(int n) {

        String x = Integer.toBinaryString(n);

        for (int i = 0; i < x.length() - 1; i++) {
            if (x.charAt(i) == x.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        int x = (n >> 1) ^ n;
        return ((x + 1) & x) == 0;
    }

    public boolean hasAlternatingBits3(int n) {
        String string = Integer.toString(n, 2);
        return true;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
