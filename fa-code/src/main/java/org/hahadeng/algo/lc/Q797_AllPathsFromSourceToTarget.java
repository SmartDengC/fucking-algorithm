package org.hahadeng.algo.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/description/">...</a>
 * <p>
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出从节点 0 到节点 n-1 的所有路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 * @author 邓聪
 * @since 2025/7/28 15:55
 */
public class Q797_AllPathsFromSourceToTarget {
    /**
     * 题目意思就是找到从开始节点到目标节点的所有路径可能
     * 通过dfs + 回溯暴力求解
     * 在进入函数的时候加入元素，在离开函数的时候删除最后一个元素
     *
     * @param graph 节点之间的关系
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, n - 1, path, ans);
        return ans;
    }

    private void dfs(int[][] graph, int cur, int target, List<Integer> path, List<List<Integer>> ans) {
        if (cur == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[cur]) {
            path.add(next);
            dfs(graph, next, target, path, ans);

            path.remove(path.size() - 1);
        }
    }

}
