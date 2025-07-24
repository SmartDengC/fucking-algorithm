package org.hahadeng.algo.basic;

/**
 * 力扣树节点
 *
 * @author 邓聪
 * @since 2025/7/23 19:51
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
