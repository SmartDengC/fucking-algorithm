package org.hahadeng.algo.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣树节点
 *
 * @author 邓聪
 * @since 2025/7/23 19:51
 */
public class TreeNode implements Comparable<TreeNode> {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 调用以构造二叉树，BFS
     *
     * @param vals 数组
     */
    public static TreeNode initTree(Integer[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int cur = 1;
        queue.offer(root);
        while (queue != null) {
            TreeNode r = queue.poll();
            if (vals[cur] == null) {
                r.left = null;
            } else {
                r.left = new TreeNode(vals[cur]);
                queue.offer(r.left);
            }
            if (++cur >= vals.length) {
                break;
            }
            if (vals[cur] == null) {
                r.right = null;
            } else {
                r.right = new TreeNode(vals[cur]);
                queue.offer(r.right);
            }
            if (++cur >= vals.length) {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // 测试
        initTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    }

    @Override
    public int compareTo(TreeNode treeNode) {
        return this.val - treeNode.val;
    }
}
