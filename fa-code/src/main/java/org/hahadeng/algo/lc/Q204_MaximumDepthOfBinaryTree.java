package org.hahadeng.algo.lc;

import org.hahadeng.algo.basic.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">...</a>
 *
 * @author 邓聪
 * @since 2025/7/23 19:49
 */
public class Q204_MaximumDepthOfBinaryTree {

    public int maxDepthFromBottomToTop(TreeNode root) {
        return dfsFromBottomToTop(root);
    }

    private int dfsFromBottomToTop(TreeNode root) {
        // 规范化
        // 自底向上（为什么，因为是到递归出口之后，在归的时候更新答案）
        // 这里可以不重新定义方法，可以直接使用maxDepth看做是dfs方法
        if (root == null) {
            return 0;
        }
        int lv = dfsFromBottomToTop(root.left);
        int rv = dfsFromBottomToTop(root.right);
        return Math.max(lv, rv) + 1;
    }


    /**
     * 自顶向下
     */
    private int ans;

    public int maxDepthFromTopToBottom(TreeNode root) {
        dfsFromTopToBottom(root, 0);
        return ans;
    }

    private void dfsFromTopToBottom(TreeNode root, int depth) {
        // 非规范化
        // 自顶向下（自顶向下不一定有返回值）
        if (root == null) {
            return;
        }
        // 规范化
        depth++;
        ans = Math.max(ans, depth);
        dfsFromTopToBottom(root.left, depth);
        dfsFromTopToBottom(root.right, depth);
    }

    /**
     * 回溯
     */
    int depth = 0;
    int res = 0;

    public int maxDepthTrace(TreeNode root) {
        dfsTrace(root);
        return res;
    }

    void dfsTrace(TreeNode root) {
        if (root == null) {
            return;
        }
        // 进来+1，并更新最大高度
        depth++;
        res = Math.max(res, depth);
        dfsTrace(root.left);
        dfsTrace(root.right);
        // 出去-1， 维护树的高度
        depth--;
    }

    /**
     * 不知道什么方式
     */

    int mx = 0;

    public int maxDepth(TreeNode root) {

        dfs(root);
        return mx;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lv = dfs(root.left);
        int rv = dfs(root.right);
        // 为什么会加一？因为mx求的是最终的值，但是lv和rv是不包含根节点的，需要加上根节点
        mx = Math.max(mx, Math.max(lv, rv) + 1);
        return 1 + Math.max(lv, rv);
    }
}
