package cn;
// 给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "egg", t = "add" 
// 
//
// 输出：true 
//
// 解释： 
//
// 字符串 s 和 t 可以通过以下方式变得相同： 
//
// 
// 将 'e' 映射为 'a'。 
// 将 'g' 映射为 'd'。 
// 
//
// 示例 2： 
//
// 
// 输入：s = "f11", t = "b23" 
// 
//
// 输出：false 
//
// 解释： 
//
// 字符串 s 和 t 无法变得相同，因为 '1' 需要同时映射到 '2' 和 '3'。 
//
// 示例 3： 
//
// 
// 输入：s = "paper", t = "title" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 813 👎 0


import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution205 {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> x = new HashMap<>();
        Map<Character, Character> y = new HashMap<>();

        // length
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (x.containsKey(a) && x.get(a) != b || y.containsKey(b) && y.get(b) != a) {
                return false;
            }

            x.put(a, b);
            y.put(b, a);
        }
        return true;
    }

    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb = new StringBuilder();

        for (String x : words) {
            int nums = 0;
            for (char c : x.toCharArray()) {
                // 使用 - 'a'的方式有一个好处就是，不用去记a的ascii码对应的数字是多少，
                // 只需要减去 a 字符就可以
                int idx = c - 'a';
                nums += weights[idx];
            }
            nums %= 26;
            // 在将数字转化成字符也可以这样用，直接用字符z-去对应数字
            // 然后在(char转化一下)
            sb.append((char) (nums + 97));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution205 solution = new Solution205();
        String[] words = {"abcd", "def", "xyz"};
        int[] weight = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        solution.mapWordWeights(words, weight);
    }
}
// leetcode submit region end(Prohibit modification and deletion)
