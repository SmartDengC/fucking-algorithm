package cn;
// 编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
// 输入：strs = ["flower","flow","flight"]
// 输出："fl"
// 
//
// 示例 2： 
//
// 
// 输入：strs = ["dog","racecar","car"]
// 输出：""
// 解释：输入不存在公共前缀。
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics 字典树 数组 字符串 👍 3460 👎 0


// leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (String r : strs) {
                // 检查当前字符r是否结束 或者是 字符不相等
                if (i == r.length() || c != r.charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Solution14 s = new Solution14();
        String[] strs = {"a"};
        s.longestCommonPrefix(strs);
    }
}
// leetcode submit region end(Prohibit modification and deletion)
