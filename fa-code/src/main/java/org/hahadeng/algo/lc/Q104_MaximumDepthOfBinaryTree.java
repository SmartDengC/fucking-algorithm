package org.hahadeng.algo.lc;

import org.hahadeng.algo.basic.TreeNode;

import java.util.*;

/**
 * @author 邓聪
 * @since 2025/8/4 18:02
 */
public class Q104_MaximumDepthOfBinaryTree {
    /**
     * BFS的第一种方式，就是把节点存进去之后，然后取出来遍历
     * 但是这种方法，没有办法记录层数。
     *
     * @param root 根节点
     * @return
     */
    public int maxDepthForFirst(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            ans.add(t.val);

            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }
        }
        return ans.size();
    }

    /**
     * 通过每次访问，都先获取队列的大小，然后在把节点取出来。
     * 这样子就能记录对应的层数了。
     *
     * @param root 根节点
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // size
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (t != null && t.left != null) {
                    q.offer(t.left);
                }
                if (t != null && t.right != null)
                    q.offer(t.right);
            }
            ans++;
        }
        return ans;
    }

    public void invoke() {
        Integer[] val = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.initTree(val);
        Q104_MaximumDepthOfBinaryTree q104 = new Q104_MaximumDepthOfBinaryTree();
        q104.maxDepth(root);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2, 1};
        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // 传入一个new出来的比较器
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
        // lambda
        Arrays.sort(arr1, (x, y) -> {
            return y - x;
        });
        // 使用Collections.reverseOrder()方法
        Arrays.sort(arr1, Collections.reverseOrder());

        TreeNode[] nodes = new TreeNode[3];
        nodes[0] = new TreeNode(3);
        nodes[1] = new TreeNode(2);
        nodes[2] = new TreeNode(1);
        Arrays.sort(nodes);
        System.out.println(Arrays.toString(nodes));
    }
}
